// models/Booking.java
package com.ecommerce.api.models;

public class Booking {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

    // Add getters, setters, and builder pattern
    public static class BookingDates {
        private String checkin;
        private String checkout;
        // Add getters and setters
    }
}
