package org.example.tests.webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.get("https://jqueryui.com/datepicker/");
        driver.get("https://demoqa.com/webtables");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void addContact(String firstName, String lastName, String email, String age, String salary, String department) {
        driver.findElement(By.xpath("//button[@id='addNewRecordButton']")).click();
        int count = 0;
        List<WebElement> registrationInputTextBoxes = driver.findElements(By.xpath("//input[contains(@class, 'mr-sm-2 form-control')]"));
        for (WebElement registrationInputTextBox : registrationInputTextBoxes) {
            if (count == 0) {
                registrationInputTextBox.sendKeys(firstName);
            } else if (count == 1) {
                registrationInputTextBox.sendKeys(lastName);
            } else if (count == 2) {
                registrationInputTextBox.sendKeys(email);
            } else if (count == 3) {
                registrationInputTextBox.sendKeys(age);
            } else if (count == 4) {
                registrationInputTextBox.sendKeys(salary);
            } else if (count == 5) {
                registrationInputTextBox.sendKeys(department);
            }
            count++;
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("//button[@id='submit']")).click();
    }

    @Test
    public void test() {
        addContact("John", "Doe", "a@a.com", "53", "100", "IT");
    }
}
