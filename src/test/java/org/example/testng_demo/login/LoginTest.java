package org.example.testng_demo.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;

    @Test(priority = 1)
    void openApp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @Test(priority = 2)
    void login() {
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("student");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");
        driver.findElement(By.xpath("//button[@id='submit']")).click();
    }

    @Test(priority = 3)
    void testMessage() {
        String actualSuccessMessage = driver.findElement(By.xpath("//h1[normalize-space()='Logged In Successfully']")).getText();
        Assert.assertEquals(actualSuccessMessage, "Logged In Successfully");
    }

    @Test(priority = 4)
    void logout() {
        driver.findElement(By.xpath("//a[normalize-space()='Log out']")).click();
        driver.quit();
    }
}