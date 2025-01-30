package com.ecommerce.api.tests.products;

import com.ecommerce.api.tests.base.TestBase;
import com.ecommerce.api.utils.RequestBuilder;
import com.ecommerce.api.utils.ResponseValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

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
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(requestBody)
                .post("/booking");

        ResponseValidator.validateStatusCode(response, 200);
        Assert.assertNotNull(response.jsonPath().getInt("bookingid"), "Booking ID should not be null");
    }

    @Test
    public void testDeleteBooking() {
        logger.info("Testing delete booking");
        // First create a booking
        String bookingBody = "{"
                + "\"firstname\": \"John\","
                + "\"lastname\": \"Doe\","
                + "\"totalprice\": 111,"
                + "\"depositpaid\": true,"
                + "\"bookingdates\": {"
                + "    \"checkin\": \"2024-01-01\","
                + "    \"checkout\": \"2024-01-02\""
                + "},"
                + "\"additionalneeds\": \"Breakfast\""
                + "}";

        Response createResponse = RequestBuilder.createBasicRequest()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(bookingBody)
                .post("/booking");

        ResponseValidator.validateStatusCode(createResponse, 200);

        // Add error handling for booking ID extraction
        try {
            int bookingId = createResponse.jsonPath().getInt("bookingid");
            logger.info("Created booking with ID: " + bookingId);

            Response deleteResponse = RequestBuilder.createBasicRequest()
                    .header("Cookie", "token=" + authToken)
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .delete("/booking/" + bookingId);

            ResponseValidator.validateStatusCode(deleteResponse, 201);
        } catch (Exception e) {
            logger.error("Failed to extract booking ID from response: " + createResponse.asString());
            Assert.fail("Failed to create booking for delete test: " + e.getMessage());
        }
    }
}
