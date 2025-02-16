package org.example.tests.sliders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SlidersTest {

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
    public void sliderTest() {
        WebElement anchor = driver.findElement(By.xpath("//h2[normalize-space()='Dynamic Web Table']"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(anchor).perform();
        WebElement minSlider = driver.findElement(By.xpath("(//div[@id='slider-range']/span)[1]"));
        WebElement maxSlider = driver.findElement(By.xpath("(//div[@id='slider-range']/span)[2]"));
        System.out.println("Min Start Location: " + minSlider.getLocation());
        actions.dragAndDropBy(minSlider, -43, 0).perform();
        System.out.println("Min End Location: " + minSlider.getLocation());
        System.out.println("Max Start Location: " + maxSlider.getLocation());
        actions.dragAndDropBy(maxSlider, 100, 0).perform();
        System.out.println("Max End Location: " + maxSlider.getLocation());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
