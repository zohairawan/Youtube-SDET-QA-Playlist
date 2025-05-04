package org.example.testng_demo.annotations;

public class AnnotationsTest {
    public static void foo() {
        System.out.println("Static Method");
    }

    public static void main(String[] args) {
        AnnotationsTest t = null;
        t.foo();
    }
}