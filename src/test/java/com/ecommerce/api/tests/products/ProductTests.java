package com.ecommerce.api.tests.products;

import com.ecommerce.api.tests.base.TestBase;
import com.ecommerce.api.utils.RequestBuilder;
import com.ecommerce.api.utils.ResponseValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductTests extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(ProductTests.class);

    @Test
    public void testCreateBooking() {
        logger.info("Testing create new booking");
        String requestBody = "{"
                + "\"firstname\": \"John\","
                + "\"lastname\": \"Doe\","
                + "\"totalprice\": 150,"
                + "\"depositpaid\": true,"
                + "\"bookingdates\": {"
                + "    \"checkin\": \"2024-02-01\","
                + "    \"checkout\": \"2024-02-05\""
                + "},"
                + "\"additionalneeds\": \"Breakfast\""
                + "}";

        Response response = RequestBuilder.createBasicRequest()
                .body(requestBody)
                .post("/booking");

        ResponseValidator.validateStatusCode(response, 200);
        ResponseValidator.validateJsonFieldExists(response, "bookingid");
    }

    @Test
    public void testDeleteBooking() {
        logger.info("Testing delete booking");
        Response response = RequestBuilder.createAuthenticatedRequest(authToken)
                .delete("/booking/1");

        ResponseValidator.validateStatusCode(response, 201);
    }
}
