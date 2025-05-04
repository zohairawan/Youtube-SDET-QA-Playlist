package org.example.testng_demo.annotations.test_level;

import org.testng.annotations.BeforeTest;

public class HooksBefore {

    @BeforeTest
    public void bt() {
        System.out.println("@BeforeTest");
    }
}
