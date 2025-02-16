package org.example.tests.screenshots;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenshotsTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void fullPageScreenshotTest() {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        takesScreenshot.getScreenshotAs(OutputType.FILE);
    }
}
