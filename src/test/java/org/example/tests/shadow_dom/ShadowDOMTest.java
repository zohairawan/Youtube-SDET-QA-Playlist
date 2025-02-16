package org.example.tests.shadow_dom;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ShadowDOMTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.get("https://testautomationpractice.blogspot.com/");
        driver.get("https://books-pwakit.appspot.com/");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void oneShadowDOMTest() {
        WebElement shadowHost = driver.findElement(By.cssSelector("div#shadow_host"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement mobileElement = shadowRoot.findElement(By.cssSelector("span.info"));
        System.out.println(mobileElement.getText());
    }

    @Test
    public void twoShadowDOMTest() {
        WebElement shadowHostOuter = driver.findElement(By.cssSelector("div#shadow_host"));
        SearchContext shadowRootOuter = shadowHostOuter.getShadowRoot();
        WebElement shadowHostInner = shadowRootOuter.findElement(By.cssSelector("div#nested_shadow_host"));
        SearchContext shadowRootInner = shadowHostInner.getShadowRoot();
        WebElement laptopElement = shadowRootInner.findElement(By.cssSelector("div#nested_shadow_content div"));
        System.out.println(laptopElement.getText());
    }

    @Test
    public void multiNestShadowDOMTest() {
        WebElement shadowHost0 = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']"));
        SearchContext shadowRoot0 = shadowHost0.getShadowRoot();
        WebElement inputBox = shadowRoot0.findElement(By.cssSelector("#input"));
        inputBox.sendKeys("Microphone checka, swinging sword lecta");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
