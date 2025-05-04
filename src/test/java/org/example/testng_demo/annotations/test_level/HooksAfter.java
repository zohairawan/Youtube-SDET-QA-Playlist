package org.example.testng_demo.annotations.test_level;

import org.testng.annotations.AfterTest;

public class HooksAfter {

    @AfterTest
    public void at() {
        System.out.println("@AfterTest");
    }
}
