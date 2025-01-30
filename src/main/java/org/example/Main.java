package org.example;

import com.ecommerce.api.config.TestConfig;

public class Main {
    public static void main(String[] args) {
        // Initialize test configuration
        TestConfig.setup();
        System.out.println("API Testing Framework initialized successfully");
    }
}
