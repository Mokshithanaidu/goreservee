package com.reservation;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Ticket class demonstrating Encapsulation
 * Keeps ticket details private with controlled access
 */
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String ticketId;
    private String userId;
    private String transportId;
    private String transportType;
    private int seatNumber;
    private String source;
    private String destination;
    private double price;
    private String bookingDate;
    private String status; // CONFIRMED, CANCELLED
    
    // Constructor
    public Ticket(String ticketId, String userId, String transportId, String transportType, 
                  int seatNumber, String source, String destination, double price) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.transportId = transportId;
        this.transportType = transportType;
        this.seatNumber = seatNumber;
        this.source = source;
        this.destination = destination;
        this.price = price;
        this.bookingDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.status = "CONFIRMED";
    }
    
    // Getters and Setters - Encapsulation
    public String getTicketId() {
        return ticketId;
    }
    
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getTransportId() {
        return transportId;
    }
    
    public void setTransportId(String transportId) {
        this.transportId = transportId;
    }
    
    public String getTransportType() {
        return transportType;
    }
    
    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }
    
    public int getSeatNumber() {
        return seatNumber;
    }
    
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
    
    public String getSource() {
        return source;
    }
    
    public void setSource(String source) {
        this.source = source;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getBookingDate() {
        return bookingDate;
    }
    
    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "\n" +
               "========================================\n" +
               "           TICKET DETAILS               \n" +
               "========================================\n" +
               "Ticket ID       : " + ticketId + "\n" +
               "Transport Type  : " + transportType + "\n" +
               "Transport ID    : " + transportId + "\n" +
               "Route           : " + source + " → " + destination + "\n" +
               "Seat Number     : " + seatNumber + "\n" +
               "Price           : ₹" + String.format("%.2f", price) + "\n" +
               "Booking Date    : " + bookingDate + "\n" +
               "Status          : " + status + "\n" +
               "========================================\n";
    }
}
