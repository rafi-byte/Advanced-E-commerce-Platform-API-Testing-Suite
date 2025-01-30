package com.ecommerce.api.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDataGenerator {
    private static final Logger logger = LoggerFactory.getLogger(TestDataGenerator.class);
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String generateBookingDates() {
        LocalDate checkin = LocalDate.now();
        LocalDate checkout = checkin.plusDays(5);

        return "{"
                + "\"checkin\": \"" + checkin.format(DATE_FORMAT) + "\","
                + "\"checkout\": \"" + checkout.format(DATE_FORMAT) + "\""
                + "}";
    }

    public static String generateRandomName() {
        return "Test" + System.currentTimeMillis();
    }
}
