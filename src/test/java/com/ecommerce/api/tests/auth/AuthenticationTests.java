package com.ecommerce.api.tests.auth;

import com.ecommerce.api.config.APIConfig;
import com.ecommerce.api.utils.RequestBuilder;
import com.ecommerce.api.utils.ResponseValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthenticationTests {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationTests.class);

    @Test
    public void testSuccessfulAuthentication() {
        String requestBody = String.format("{"
                + "\"username\": \"%s\","
                + "\"password\": \"%s\""
                + "}", APIConfig.getAuthUsername(), APIConfig.getAuthPassword());

        Response response = RequestBuilder.createBasicRequest()
                .body(requestBody)
                .post("/auth");

        ResponseValidator.validateStatusCode(response, 200);
        // Use Assert instead of validateJsonFieldExists
        Assert.assertNotNull(response.jsonPath().getString("token"), "Token should not be null");
    }

    @Test
    public void testFailedAuthentication() {
        String requestBody = "{"
                + "\"username\": \"invalid\","
                + "\"password\": \"invalid\""
                + "}";

        Response response = RequestBuilder.createBasicRequest()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post(APIConfig.getAuthEndpoint());

        // Change expected status code to 200 as the API returns 200 even for invalid credentials
        ResponseValidator.validateStatusCode(response, 200);
        // Add validation for error message instead
        Assert.assertFalse(response.jsonPath().getString("token") != null,
                "Token should not be generated for invalid credentials");
    }


}
