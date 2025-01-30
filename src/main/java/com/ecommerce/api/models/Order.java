package com.ecommerce.api.models;

import java.time.LocalDateTime;

public class Order {
    private int id;
    private int bookingId;
    private String firstname;
    private String lastname;
    private double totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

    public static class BookingDates {
        private LocalDateTime checkin;
        private LocalDateTime checkout;

        // Getters and Setters
        public LocalDateTime getCheckin() { return checkin; }
        public void setCheckin(LocalDateTime checkin) { this.checkin = checkin; }
        public LocalDateTime getCheckout() { return checkout; }
        public void setCheckout(LocalDateTime checkout) { this.checkout = checkout; }
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getBookingId() { return bookingId; }
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }
    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public double getTotalprice() { return totalprice; }
    public void setTotalprice(double totalprice) { this.totalprice = totalprice; }
    public boolean isDepositpaid() { return depositpaid; }
    public void setDepositpaid(boolean depositpaid) { this.depositpaid = depositpaid; }
    public BookingDates getBookingdates() { return bookingdates; }
    public void setBookingdates(BookingDates bookingdates) { this.bookingdates = bookingdates; }
    public String getAdditionalneeds() { return additionalneeds; }
    public void setAdditionalneeds(String additionalneeds) { this.additionalneeds = additionalneeds; }
}
