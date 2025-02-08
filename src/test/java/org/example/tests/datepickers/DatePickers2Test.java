package org.example.tests.datepickers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Month;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DatePickers2Test {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void datePickers2Test() {
        String year = "2027";
        String month = "Sep";
        String day = "20";
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(By.xpath("(//a[normalize-space()='Home'])[1]"))).perform();
        WebElement datePicker2InputBox = driver.findElement(By.xpath("//input[@id='txtDate']"));
        datePicker2InputBox.click();
        WebElement monthSelectDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select select = new Select(monthSelectDropdown);
        select.selectByVisibleText(month);
        WebElement yearSelectDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        select = new Select(yearSelectDropdown);
        select.selectByVisibleText(year);
        List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//a"));
        for (WebElement webElement : days) {
            if (webElement.getText().equals(day)) {
                webElement.click();
            }
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void datePicker2AltTest() {
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(By.xpath("//h2[normalize-space()='Upload Files']"))).perform();

        WebElement datePicker2InputBox = driver.findElement(By.xpath("//input[@id='txtDate']"));
        datePicker2InputBox.click();

        WebElement currentDisplayedMonthBox = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        currentDisplayedMonthBox.click();
        String currentDisplayedMonthStr = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']/option[@selected]")).getText();

        String targetMonthStr = "Aug";
        String targetYearStr = "2020";
        String targetDayStr = "23";

        // Convert String month to Month object
        Month currentDisplayedMonthObj = DatePickers2UtilTest.convertMonth(currentDisplayedMonthStr);
        Month targetMonthObj = DatePickers2UtilTest.convertMonth(targetMonthStr);
        int monthOrder = targetMonthObj.compareTo(currentDisplayedMonthObj);
        System.out.println(monthOrder);

        while (true) {
            if (monthOrder < 0) {
                driver.findElement(By.xpath("//a[@title='Prev']")).click();
            } else if (monthOrder > 0) {
                driver.findElement(By.xpath("//a[@title='Next']")).click();
            } else {
                break;
            }
            currentDisplayedMonthStr = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']/option[@selected]")).getText();
            currentDisplayedMonthObj = DatePickers2UtilTest.convertMonth(currentDisplayedMonthStr);
            monthOrder = targetMonthObj.compareTo(currentDisplayedMonthObj);
        }

        // Select year
        WebElement currentDisplayedYearBox = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select select = new Select(currentDisplayedYearBox);
        select.selectByVisibleText(targetYearStr);

        List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr//a"));
        for (WebElement day : days) {
            if (day.getText().equals(targetDayStr)) {
                day.click();
                break;
            }
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
