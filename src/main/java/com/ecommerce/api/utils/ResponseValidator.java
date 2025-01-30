package com.ecommerce.api.utils;

import io.restassured.response.Response;
import org.testng.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseValidator {
    private static final Logger logger = LoggerFactory.getLogger(ResponseValidator.class);

    public static void validateStatusCode(Response response, int expectedStatusCode) {
        logger.info("Validating status code. Expected: {}", expectedStatusCode);
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode,
                "Expected status code: " + expectedStatusCode + " but got: " + response.getStatusCode());
    }

    public static void validateResponseTime(Response response, long maxTimeInMs) {
        logger.info("Validating response time. Max allowed: {} ms", maxTimeInMs);
        Assert.assertTrue(response.getTime() <= maxTimeInMs,
                "Response time exceeded " + maxTimeInMs + "ms. Actual time: " + response.getTime() + "ms");
    }

    public static void validateJsonField(Response response, String jsonPath, Object expectedValue) {
        logger.info("Validating JSON field: {}", jsonPath);
        Assert.assertEquals(response.jsonPath().get(jsonPath), expectedValue,
                "JSON field value mismatch for: " + jsonPath);
    }

    public static void validateJsonFieldExists(Response response, String jsonPath) {
        logger.info("Validating JSON field exists: {}", jsonPath);
        Assert.assertNotNull(response.jsonPath().get(jsonPath),
                "JSON field not found: " + jsonPath);
    }
}
