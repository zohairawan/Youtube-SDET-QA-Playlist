package org.example.tests.mouse_actions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDropTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/drag_drop.html");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void dragAndDropTest() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350);");
        WebElement bankDraggableBlock = driver.findElement(By.xpath("//li[@id='credit2']/a[normalize-space()='BANK']"));
        WebElement bankDroppableBlock = driver.findElement(By.xpath("//ol[@id='bank']/li"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(bankDraggableBlock, bankDroppableBlock).perform();
        WebElement debitSide5000 = driver.findElement(By.xpath("(//li[@data-id='2']//a)[1]"));
        WebElement debitSideAmount = driver.findElement(By.xpath("//ol[@id='amt7']/li"));
        actions.dragAndDrop(debitSide5000, debitSideAmount).perform();

        WebElement salesBlock = driver.findElement(By.xpath("//li[@id='credit1']/a"));
        WebElement creditSideAccount = driver.findElement(By.xpath("//ol[@id='loan']/li"));
        actions.dragAndDrop(salesBlock, creditSideAccount).perform();
        WebElement creditSideAmount = driver.findElement(By.xpath("//ol[@id='amt8']/li"));
        actions.dragAndDrop(debitSide5000, creditSideAmount).perform();

        WebElement perfectButton = driver.findElement(By.xpath("//div[@id='equal']/a[normalize-space()='Perfect!']"));
        Assert.assertTrue(perfectButton.isDisplayed());
        Assert.assertEquals(perfectButton.getText(), "Perfect!");
    }
}
