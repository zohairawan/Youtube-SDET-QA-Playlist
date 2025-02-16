package org.example.tests.keyboard_actions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class KeyboardActionsTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void pressKeysTest() {
        driver.get("https://text-compare.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 150)");

        WebElement inputTextArea1 = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
        inputTextArea1.sendKeys("Hello!");

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
        actions.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void openNewTabTest() {
        driver.get("https://testautomationpractice.blogspot.com/");
        Actions actions = new Actions(driver);
        WebElement anchor = driver.findElement(By.xpath("//div[contains(text(), 'Theme images by')]"));
        actions.scrollToElement(anchor).perform();
        WebElement link = driver.findElement(By.xpath("//a[normalize-space()='Hidden Elements & AJAX']"));
        actions.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).perform();

//        Set<String> windowHandles = driver.getWindowHandles();
//        for (String windowHandle : windowHandles) {
//            driver.switchTo().window(windowHandle);
//        }
        List<String> ids = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(ids.get(1));

        String actualHeader = driver.findElement(By.xpath("//h3[normalize-space()='Hidden Elements & AJAX']")).getText();
        String expectedHeader = "Hidden Elements & AJAX";
        Assert.assertEquals(actualHeader, expectedHeader);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
