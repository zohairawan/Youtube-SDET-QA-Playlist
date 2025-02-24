package org.example.tests.data_driven_testing_excel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class LoginTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginTestNegative() throws IOException {
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(By.xpath("//h5[normalize-space()='Test case 1: Positive LogIn test']"))).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String excelFilePath = System.getProperty("user.dir") + "\\testdata\\data.xlsx";
        String sheetName = "LoginData";
        int rows = ExcelUtils.getRowCount(excelFilePath, sheetName);
        for (int row = 2; row <= rows; row++) {
            // Read data from Excel file
            String username = ExcelUtils.getCellData(excelFilePath, sheetName, row, 0);
            System.out.println(username);
            String password = ExcelUtils.getCellData(excelFilePath, sheetName, row, 1);
            System.out.println(password);
            String expectedErrorMessage = ExcelUtils.getCellData(excelFilePath, sheetName, row, 2);
            System.out.println(expectedErrorMessage);

            // Pass above data into application
            WebElement usernameInputBox = driver.findElement(By.xpath("//input[@id='username']"));
            usernameInputBox.sendKeys(username);
            WebElement passwordInputBox = driver.findElement(By.xpath("//input[@id='password']"));
            passwordInputBox.sendKeys(password);
            WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
            submitButton.click();

            // Validation
            String actualErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='error']"))).getText();
            System.out.println(actualErrorMessage);
            Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
        }
    }

    @Test
    public void newUtilTest() throws IOException {
        ExcelUtilz xl = new ExcelUtilz(System.getProperty("user.dir") + "\\testdata\\DummyData.xlsx", "NegativeLogin");
        int rowCount = xl.getRowCount();
        for (int i = 1; i <= rowCount ; i++) {
            String username = xl.getCellData(i, 0);
            System.out.println("Username: " + username);
            String password = xl.getCellData(i, 1);
            System.out.println("Password: " + password);
            String expectedErrorMessage = xl.getCellData(i, 2);
            System.out.println("Expected error message:" + expectedErrorMessage);

            driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
            driver.findElement(By.xpath("//button[@id='submit']")).click();
            String actualErrorMessage = driver.findElement(By.xpath("//div[@id='error']")).getText();
            System.out.println(actualErrorMessage);
//            Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
            if (actualErrorMessage.contains(expectedErrorMessage)) {
                xl.setCellData(i,4,"Fail");
            }
        }
        xl.close();
    }
}
