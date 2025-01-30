// src/main/java/com/ecommerce/api/config/APIConfig.java
package com.ecommerce.api.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class APIConfig {
    private static final Logger log = LoggerFactory.getLogger(APIConfig.class);
    private static final Properties properties = new Properties();

    static {
        try (FileInputStream file = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(file);
            log.info("Configuration loaded successfully");
        } catch (IOException e) {
            log.error("Error loading config file: {}", e.getMessage());
            throw new RuntimeException("Configuration file not found", e);
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("api.base.url");
    }

    public static String getAuthUsername() {
        return properties.getProperty("auth.username");
    }

    public static String getAuthPassword() {
        return properties.getProperty("auth.password");
    }

    public static String getAuthEndpoint() {
        return properties.getProperty("endpoint.auth");
    }

    public static String getBookingEndpoint() {
        return properties.getProperty("endpoint.booking");
    }

    public static int getConnectionTimeout() {
        return Integer.parseInt(properties.getProperty("timeout.connection"));
    }

    public static String getContentType() {
        return properties.getProperty("header.content.type");
    }
}
