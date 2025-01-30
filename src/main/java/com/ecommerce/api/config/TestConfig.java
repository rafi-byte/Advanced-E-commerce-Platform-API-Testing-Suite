package com.ecommerce.api.config;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestConfig {
    private static final Logger logger = LoggerFactory.getLogger(TestConfig.class);

    public static void setup() {
        logger.info("Setting up test configuration");
        RestAssured.baseURI = APIConfig.getBaseUrl();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
