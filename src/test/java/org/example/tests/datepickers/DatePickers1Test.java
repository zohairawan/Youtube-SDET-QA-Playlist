package org.example.tests.datepickers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class DatePickers1Test {

    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void setUp() {
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void datePickerUsingSendKeysTest() {
//        WebElement iFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(0);
        WebElement datePickerInputBox = driver.findElement(By.xpath("//input[@id='datepicker']"));
        datePickerInputBox.sendKeys("01/05/1999");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void datePickerUsingSelectDateTest() {
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//input[@id='datepicker']")).click();
        selectFutureDate("mar", "8", "2026");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void selectPastDate(String month, String day, String year) {
        // Select month and year
        while (true) {
            String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            if (currentMonth.toLowerCase().contains(month.toLowerCase()) && currentYear.equals(year)) {
                break;
            }
            driver.findElement(By.xpath("//a[@title='Prev']")).click();
        }

        // Select day
        List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
        for (WebElement dayy : days) {
            if (dayy.getText().equals(day)) {
                dayy.click();
                break;
            }
        }
    }

    @Test
    public void selectFutureDate(String month, String day, String year) {
        // Select month and year
        while (true) {
            String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            if (currentMonth.toLowerCase().contains(month.toLowerCase()) && currentYear.equals(year)) {
                break;
            }
            driver.findElement(By.xpath("//a[@title='Next']")).click();
        }

        // Select day
        List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
        for (WebElement dayy : days) {
            if (dayy.getText().equals(day)) {
                dayy.click();
                break;
            }
        }
    }
}