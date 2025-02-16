package org.example.tests.javascript_executor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JSETest {

    private WebDriver driver;

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
    public void jseTest() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo({top:document.body.scrollHeight});");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        js.executeScript("window.scrollTo({top:0})");
//        WebElement anchor = driver.findElement(By.xpath("//label[normalize-space()='Phone:']"));
//        js.executeScript("window.scrollTo({ top: 1000, behavior: 'smooth' });");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        js.executeScript("arguments[0].scrollIntoView({behavior:'smooth', block:'center'})", anchor);
//
//        WebElement nameInputBox = driver.findElement(By.xpath("//input[@id='name']"));
//        String name = "Johnathon";
//        js.executeScript("arguments[0].value=arguments[1];", nameInputBox, name);
//
//        WebElement emailInputBox = driver.findElement(By.xpath("//input[@id='email']"));
//        String email = "johndoe@a.com";
//        js.executeScript("arguments[0].value=arguments[1];", emailInputBox, email);
//
//        WebElement phoneNumberInputBox = driver.findElement(By.xpath("//input[@id='phone']"));
//        String phoneNumber = "111-111-2222";
//        js.executeScript("arguments[0].value=arguments[1];", phoneNumberInputBox, phoneNumber);
//
//        WebElement addressInputBox = driver.findElement(By.xpath("//textarea[@id='textarea']"));
//        String address = "123 Main St";
//        js.executeScript("arguments[0].value=arguments[1];", addressInputBox, address);
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        WebElement anchor2 = driver.findElement(By.xpath("//label[normalize-space()='Gender:']"));
//        js.executeScript("arguments[0].scrollIntoView({behavior:'smooth'})", anchor2);
//
//        WebElement radioBtn = driver.findElement(By.xpath("//input[@id='male']"));
//        js.executeScript("arguments[0].click();", radioBtn);
//
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        js.executeScript("arguments[0].scrollIntoView({behavior:'smooth', block:'center'})", anchor);
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}
