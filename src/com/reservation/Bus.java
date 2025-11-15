package com.reservation;

/**
 * Bus class demonstrating Inheritance and Polymorphism
 * Extends the Transport abstract class
 */
public class Bus extends Transport {
    private String busType; // AC, Non-AC, Sleeper, etc.
    
    public Bus(String transportId, String source, String destination, int totalSeats, double basePrice, String busType) {
        super(transportId, source, destination, totalSeats, basePrice);
        this.busType = busType;
    }
    
    @Override
    public String getTransportType() {
        return "BUS";
    }
    
    @Override
    public double calculatePrice(int seatNumber) {
        // Different pricing logic for buses
        double price = getBasePrice();
        
        // Window seats (odd numbers) cost more
        if (seatNumber % 2 != 0) {
            price += 50;
        }
        
        // AC buses cost more
        if (busType.equalsIgnoreCase("AC")) {
            price += 200;
        } else if (busType.equalsIgnoreCase("Sleeper")) {
            price += 300;
        }
        
        return price;
    }
    
    public String getBusType() {
        return busType;
    }
    
    @Override
    public String toString() {
        return super.toString() + " [Type: " + busType + "]";
    }
}
