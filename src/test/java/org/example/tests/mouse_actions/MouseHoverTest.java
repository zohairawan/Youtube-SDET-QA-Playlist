package org.example.tests.mouse_actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class MouseHoverTest {

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
    public void mouseHoverTest() {
        WebElement anchor = driver.findElement(By.xpath("//h2[normalize-space()='Drag and Drop']"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(anchor).perform();
        WebElement pointMeHoverDropdown = driver.findElement(By.xpath("//button[@class='dropbtn']"));
        WebElement innerDropdown = driver.findElement(By.xpath("//button[@class='dropbtn']/..//a[normalize-space()='Laptops']"));
        List<WebElement> products = driver.findElements(By.xpath("//button[@class='dropbtn']/..//a"));
        actions.moveToElement(pointMeHoverDropdown).moveToElement(innerDropdown).perform();
        for (WebElement product : products) {
            System.out.println(product.getText());
        }
//        System.out.println(innerDropdown.getText());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        innerDropdown.click();
    }

    @Test
    public void doubleClickTest() {
        Actions actions = new Actions(driver);
        WebElement scrollToThisElement = driver.findElement(By.xpath("//h2[normalize-space()='Upload Files']"));
        actions.scrollToElement(scrollToThisElement).perform();
        WebElement field1InputBox = driver.findElement(By.xpath("//input[@id='field1']"));
        String field1Value = field1InputBox.getDomAttribute("value");
        WebElement copyTextButton = driver.findElement(By.xpath("//button[@ondblclick='myFunction1()']"));
        WebElement field2InputBox = driver.findElement(By.xpath("//input[@id='field2']"));
        actions.doubleClick(copyTextButton).perform();
        String field2Value = field2InputBox.getDomAttribute("value");
        System.out.println("Field 1: " + field1Value + " , Field 2: " + field2Value);
        Assert.assertEquals(field1Value, field2Value);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void dragAndDropTest() {
        WebElement anchor = driver.findElement(By.xpath("//h2[normalize-space()='Static Web Table']"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(anchor).perform();
        WebElement draggableElement = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement droppableElement = driver.findElement(By.xpath("//div[@id='droppable']"));
        actions.dragAndDrop(draggableElement, droppableElement).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
