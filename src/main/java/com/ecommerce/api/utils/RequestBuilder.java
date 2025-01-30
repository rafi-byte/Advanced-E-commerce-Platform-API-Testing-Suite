package com.ecommerce.api.utils;

import com.ecommerce.api.config.APIConfig;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestBuilder {
    private static final Logger logger = LoggerFactory.getLogger(RequestBuilder.class);

    public static RequestSpecification createBasicRequest() {
        logger.info("Creating basic request specification");
        return RestAssured.given()
                .baseUri(APIConfig.getBaseUrl())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);
    }

    public static RequestSpecification createAuthenticatedRequest(String token) {
        logger.info("Creating authenticated request specification");
        return createBasicRequest()
                .header("Cookie", "token=" + token);
    }

    public static String getAuthToken() {
        logger.info("Generating auth token");
        String requestBody = String.format("{\"username\": \"%s\", \"password\": \"%s\"}",
                APIConfig.getAuthUsername(), APIConfig.getAuthPassword());

        return RestAssured.given()
                .baseUri(APIConfig.getBaseUrl())
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(APIConfig.getAuthEndpoint())
                .jsonPath()
                .getString("token");
    }
}
