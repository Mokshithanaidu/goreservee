package com.reservation;

/**
 * Train class demonstrating Inheritance and Polymorphism
 * Extends the Transport abstract class
 */
public class Train extends Transport {
    private String trainClass; // 1A, 2A, 3A, SL, etc.
    
    public Train(String transportId, String source, String destination, int totalSeats, double basePrice, String trainClass) {
        super(transportId, source, destination, totalSeats, basePrice);
        this.trainClass = trainClass;
    }
    
    @Override
    public String getTransportType() {
        return "TRAIN";
    }
    
    @Override
    public double calculatePrice(int seatNumber) {
        // Different pricing logic for trains
        double price = getBasePrice();
        
        // Lower berths (1-20) cost more
        if (seatNumber <= 20) {
            price += 100;
        }
        
        // Class-based pricing
        switch (trainClass.toUpperCase()) {
            case "1A":
                price += 500;
                break;
            case "2A":
                price += 350;
                break;
            case "3A":
                price += 200;
                break;
            case "SL":
                price += 50;
                break;
            default:
                break;
        }
        
        return price;
    }
    
    public String getTrainClass() {
        return trainClass;
    }
    
    @Override
    public String toString() {
        return super.toString() + " [Class: " + trainClass + "]";
    }
}
