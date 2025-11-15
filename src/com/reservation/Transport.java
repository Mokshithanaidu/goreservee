package com.reservation;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class demonstrating Abstraction
 * This is the base class for all transport types
 */
public abstract class Transport {
    private String transportId;
    private String source;
    private String destination;
    private int totalSeats;
    private List<Integer> availableSeats;
    private double basePrice;
    
    // Constructor
    public Transport(String transportId, String source, String destination, int totalSeats, double basePrice) {
        this.transportId = transportId;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.basePrice = basePrice;
        this.availableSeats = new ArrayList<>();
        initializeSeats();
    }
    
    // Initialize all seats as available
    private void initializeSeats() {
        for (int i = 1; i <= totalSeats; i++) {
            availableSeats.add(i);
        }
    }
    
    // Abstract methods - must be implemented by subclasses
    public abstract double calculatePrice(int seatNumber);
    public abstract String getTransportType();
    
    // Concrete method - common to all transports
    public boolean bookSeat(int seatNumber) {
        if (availableSeats.contains(seatNumber)) {
            availableSeats.remove(Integer.valueOf(seatNumber));
            return true;
        }
        return false;
    }
    
    public boolean cancelSeat(int seatNumber) {
        if (!availableSeats.contains(seatNumber) && seatNumber > 0 && seatNumber <= totalSeats) {
            availableSeats.add(seatNumber);
            return true;
        }
        return false;
    }
    
    public boolean isSeatAvailable(int seatNumber) {
        return availableSeats.contains(seatNumber);
    }
    
    // Encapsulation - Getters and Setters
    public String getTransportId() {
        return transportId;
    }
    
    public String getSource() {
        return source;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public int getTotalSeats() {
        return totalSeats;
    }
    
    public List<Integer> getAvailableSeats() {
        return new ArrayList<>(availableSeats); // Return copy to protect internal data
    }
    
    public double getBasePrice() {
        return basePrice;
    }
    
    public void setAvailableSeats(List<Integer> seats) {
        this.availableSeats = new ArrayList<>(seats);
    }
    
    @Override
    public String toString() {
        return getTransportType() + " [ID: " + transportId + ", " + source + " → " + destination + 
               ", Available Seats: " + availableSeats.size() + "/" + totalSeats + "]";
    }
}
