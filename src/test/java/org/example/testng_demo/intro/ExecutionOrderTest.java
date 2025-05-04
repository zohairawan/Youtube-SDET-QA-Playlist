/**
 * TestNG, by default, execute tests in alphabetical order
 * If we want to run the tests in a specific order we can use priority
 */

package org.example.testng_demo.intro;

import org.testng.annotations.Test;

public class ExecutionOrderTest {

    @Test(priority = 1)
    void openApp() {
        System.out.println("Opening application...");
    }

    @Test(priority = 2)
    void login() {
        System.out.println("Logging into application...");
    }

    @Test(priority = 3)
    void logout() {
        System.out.println("Logging out of application...");
    }
}
