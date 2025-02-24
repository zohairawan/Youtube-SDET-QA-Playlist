package org.example.tests.data_driven_testing_excel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class CalcTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void calcTest() throws IOException {
        // Locate web elements
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);
        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='CIT-chart-submit']")));
        actions.scrollToElement(submitButton).perform();
        WebElement depositBox = driver.findElement(By.xpath("//input[@id='mat-input-0']"));
        WebElement lengthBox = driver.findElement(By.xpath("//input[@id='mat-input-1']"));
        WebElement interestBox = driver.findElement(By.xpath("//input[@id='mat-input-2']"));
        WebElement compoundDropdown = driver.findElement(By.xpath("//div[@id='mat-select-value-1']"));
        WebElement actualTotalElement = driver.findElement(By.xpath("//span[@id='displayTotalValue']"));

        //
        String excelFilePath = System.getProperty("user.dir") + "\\testdata\\CalcData.xlsx";
        String sheetName = "Data";
        ExcelUtilz xl = new ExcelUtilz(excelFilePath, sheetName);
        int totalRows = xl.getRowCount();
        for (int i = 1; i <= totalRows; i++) {
            depositBox.clear();
            lengthBox.clear();
            interestBox.clear();

            // Read data from excel
            String depositAmount = xl.getCellData(i, 0);
            depositAmount = depositAmount.substring(0, depositAmount.length() - 2);
            String length = xl.getCellData(i, 1);
            length = length.substring(0, length.length() - 2);
            String interest = xl.getCellData(i, 2);
            interest = interest.substring(0, interest.length() - 2);
            String compounding = xl.getCellData(i, 3);
            String expectedTotal = xl.getCellData(i, 4);

            depositBox.sendKeys(depositAmount);
            lengthBox.sendKeys(length);
            interestBox.sendKeys(interest);
            compoundDropdown.click();
            List<WebElement> compoundingOptions = driver.findElements(By.xpath("//div[@id= 'mat-select-0-panel']/mat-option"));
            for (WebElement compoundingOption : compoundingOptions) {
                if (compoundingOption.getText().equals(compounding)) {
                    compoundingOption.click();
                    break;
                }
            }
            submitButton.click();
            String actualTotal = actualTotalElement.getText().replaceAll("\\$", "").replaceAll(",","");
            if (actualTotal.equals(expectedTotal)) {
                xl.setCellData(i,6,"Pass");
            } else {
                xl.setCellData(i,6,"Fail");
            }
//            Assert.assertEquals(actualTotal, expectedTotal);
        }
        xl.close();
    }
}
