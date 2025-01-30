package com.ecommerce.api.tests.orders;

import com.ecommerce.api.tests.base.TestBase;
import com.ecommerce.api.utils.RequestBuilder;
import com.ecommerce.api.utils.ResponseValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderTests extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(OrderTests.class);

    @Test
    public void testGetBookingById() {
        logger.info("Testing get booking by ID");
        Response response = RequestBuilder.createBasicRequest()
                .get("/booking/1");

        ResponseValidator.validateStatusCode(response, 200);
        ResponseValidator.validateResponseTime(response, 3000);
    }

    @Test
    public void testUpdateBooking() {
        logger.info("Testing update booking");
        String requestBody = "{"
                + "\"firstname\": \"James\","
                + "\"lastname\": \"Brown\","
                + "\"totalprice\": 111,"
                + "\"depositpaid\": true,"
                + "\"bookingdates\": {"
                + "    \"checkin\": \"2024-01-01\","
                + "    \"checkout\": \"2024-01-02\""
                + "},"
                + "\"additionalneeds\": \"Breakfast\""
                + "}";

        Response response = RequestBuilder.createAuthenticatedRequest(authToken)
                .body(requestBody)
                .put("/booking/1");

        ResponseValidator.validateStatusCode(response, 200);
    }
}
