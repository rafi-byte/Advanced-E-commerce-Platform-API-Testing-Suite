package com.ecommerce.api.tests.orders;

import com.ecommerce.api.tests.base.TestBase;
import com.ecommerce.api.utils.RequestBuilder;
import com.ecommerce.api.utils.ResponseValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class OrderTests extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(OrderTests.class);

    @Test
    public void testGetBookingById() {
        logger.info("Testing get booking by ID");
        String createBookingBody = "{"
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

        try {
            Response createResponse = RequestBuilder.createBasicRequest()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .body(createBookingBody)
                    .post("/booking");

            ResponseValidator.validateStatusCode(createResponse, 200);

            int bookingId = createResponse.jsonPath().getInt("bookingid");
            logger.info("Created booking with ID: " + bookingId);

            Response getResponse = RequestBuilder.createBasicRequest()
                    .header("Accept", "application/json")
                    .get("/booking/" + bookingId);

            ResponseValidator.validateStatusCode(getResponse, 200);
        } catch (Exception e) {
            logger.error("Error in test: " + e.getMessage());
            Assert.fail("Test failed: " + e.getMessage());
        }
    }

    @Test
    public void testUpdateBooking() {
        logger.info("Testing update booking");
        String bookingBody = "{"
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

        try {
            Response createResponse = RequestBuilder.createBasicRequest()
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .body(bookingBody)
                    .post("/booking");

            ResponseValidator.validateStatusCode(createResponse, 200);

            int bookingId = createResponse.jsonPath().getInt("bookingid");
            logger.info("Created booking with ID: " + bookingId);

            Response updateResponse = RequestBuilder.createBasicRequest()
                    .header("Cookie", "token=" + authToken)
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .body(bookingBody)
                    .put("/booking/" + bookingId);

            ResponseValidator.validateStatusCode(updateResponse, 200);
        } catch (Exception e) {
            logger.error("Error in test: " + e.getMessage());
            Assert.fail("Test failed: " + e.getMessage());
        }
    }
}
