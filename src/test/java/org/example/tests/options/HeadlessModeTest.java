package org.example.tests.options;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HeadlessModeTest {

    WebDriver driver;
    ChromeOptions chromeOptions = new ChromeOptions();

    @BeforeTest
    public void setUp() {
        chromeOptions.addArguments("--headless=new");
        driver = new ChromeDriver(chromeOptions);
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void headlessModeTest() {
        WebElement nameElement = driver.findElement(By.xpath("//label[text()='Name:']"));
        String actualText = nameElement.getText();
        String expectedText = "Name:";
        Assert.assertEquals(actualText, expectedText);

        WebElement guiElement = driver.findElement(By.xpath("//a[text()='GUI Elements']"));
        Assert.assertEquals(guiElement.getText(), "GUI Elements");
    }
}
