package com.reservation;

import java.io.*;
import java.util.*;

/**
 * ReservationSystem - Core business logic class
 * Demonstrates use of Collections (ArrayList, HashMap) and File I/O
 */
public class ReservationSystem {
    // Collections for storing data
    private Map<String, Transport> transports; // transportId -> Transport
    private Map<String, User> users; // userId -> User
    private List<Ticket> tickets; // All tickets
    
    // File paths for persistence
    private static final String TICKETS_FILE = "data/tickets.dat";
    private static final String USERS_FILE = "data/users.dat";
    private static final String TRANSPORTS_FILE = "data/transports.dat";
    
    private int ticketCounter;
    
    public ReservationSystem() {
        transports = new HashMap<>();
        users = new HashMap<>();
        tickets = new ArrayList<>();
        ticketCounter = 1000;
        
        // Create data directory if it doesn't exist
        createDataDirectory();
        
        // Initialize with sample data
        initializeSampleData();
        
        // Load data from files
        loadData();
    }
    
    // Create data directory
    private void createDataDirectory() {
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            if (dataDir.mkdirs()) {
                System.out.println("✅ Created data directory for file storage");
            }
        }
    }
    
    // Initialize sample transports
    private void initializeSampleData() {
        // Add sample buses
        Transport bus1 = new Bus("BUS001", "Mumbai", "Pune", 40, 500.0, "AC");
        Transport bus2 = new Bus("BUS002", "Delhi", "Jaipur", 35, 600.0, "Sleeper");
        Transport bus3 = new Bus("BUS003", "Bangalore", "Chennai", 45, 550.0, "Non-AC");
        
        // Add sample trains
        Transport train1 = new Train("TRN001", "Mumbai", "Delhi", 72, 800.0, "3A");
        Transport train2 = new Train("TRN002", "Kolkata", "Chennai", 80, 900.0, "2A");
        Transport train3 = new Train("TRN003", "Bangalore", "Hyderabad", 60, 700.0, "SL");
        
        transports.put(bus1.getTransportId(), bus1);
        transports.put(bus2.getTransportId(), bus2);
        transports.put(bus3.getTransportId(), bus3);
        transports.put(train1.getTransportId(), train1);
        transports.put(train2.getTransportId(), train2);
        transports.put(train3.getTransportId(), train3);
    }
    
    // Register a new user
    public User registerUser(String name, String email, String phone) {
        String userId = "USER" + String.format("%04d", users.size() + 1);
        User user = new User(userId, name, email, phone);
        users.put(userId, user);
        saveData();
        return user;
    }
    
    // Get user by ID
    public User getUser(String userId) {
        return users.get(userId);
    }
    
    // Search transports by source and destination
    public List<Transport> searchTransports(String source, String destination) {
        List<Transport> result = new ArrayList<>();
        for (Transport transport : transports.values()) {
            if (transport.getSource().equalsIgnoreCase(source) && 
                transport.getDestination().equalsIgnoreCase(destination)) {
                result.add(transport);
            }
        }
        return result;
    }
    
    // Get all available transports
    public List<Transport> getAllTransports() {
        return new ArrayList<>(transports.values());
    }
    
    // Book a ticket
    public Ticket bookTicket(String userId, String transportId, int seatNumber) {
        User user = users.get(userId);
        Transport transport = transports.get(transportId);
        
        if (user == null) {
            System.out.println("❌ User not found!");
            return null;
        }
        
        if (transport == null) {
            System.out.println("❌ Transport not found!");
            return null;
        }
        
        if (!transport.isSeatAvailable(seatNumber)) {
            System.out.println("❌ Seat " + seatNumber + " is not available!");
            return null;
        }
        
        // Book the seat
        if (transport.bookSeat(seatNumber)) {
            double price = transport.calculatePrice(seatNumber);
            String ticketId = "TKT" + String.format("%06d", ticketCounter++);
            
            Ticket ticket = new Ticket(
                ticketId,
                userId,
                transportId,
                transport.getTransportType(),
                seatNumber,
                transport.getSource(),
                transport.getDestination(),
                price
            );
            
            tickets.add(ticket);
            saveData();
            
            System.out.println("✅ Ticket booked successfully!");
            return ticket;
        }
        
        return null;
    }
    
    // Cancel a ticket
    public boolean cancelTicket(String ticketId) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId().equals(ticketId) && 
                ticket.getStatus().equals("CONFIRMED")) {
                
                // Release the seat
                Transport transport = transports.get(ticket.getTransportId());
                if (transport != null) {
                    transport.cancelSeat(ticket.getSeatNumber());
                    ticket.setStatus("CANCELLED");
                    saveData();
                    System.out.println("✅ Ticket cancelled successfully!");
                    return true;
                }
            }
        }
        System.out.println("❌ Ticket not found or already cancelled!");
        return false;
    }
    
    // Get user's booking history
    public List<Ticket> getUserBookings(String userId) {
        List<Ticket> userTickets = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getUserId().equals(userId)) {
                userTickets.add(ticket);
            }
        }
        return userTickets;
    }
    
    // Get ticket by ID
    public Ticket getTicket(String ticketId) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId().equals(ticketId)) {
                return ticket;
            }
        }
        return null;
    }
    
    // View available seats for a transport
    public void viewAvailableSeats(String transportId) {
        Transport transport = transports.get(transportId);
        if (transport != null) {
            List<Integer> availableSeats = transport.getAvailableSeats();
            System.out.println("\n📋 Available Seats for " + transport.getTransportId() + ":");
            System.out.println("Total: " + availableSeats.size() + " seats available");
            System.out.println("Seats: " + availableSeats);
        } else {
            System.out.println("❌ Transport not found!");
        }
    }
    
    // File I/O - Save data
    @SuppressWarnings("unchecked")
    private void saveData() {
        try {
            // Save tickets
            ObjectOutputStream ticketsOut = new ObjectOutputStream(new FileOutputStream(TICKETS_FILE));
            ticketsOut.writeObject(tickets);
            ticketsOut.writeInt(ticketCounter);
            ticketsOut.close();
            
            // Save users
            ObjectOutputStream usersOut = new ObjectOutputStream(new FileOutputStream(USERS_FILE));
            usersOut.writeObject(users);
            usersOut.close();
            
            // Save transports (seat availability)
            ObjectOutputStream transportsOut = new ObjectOutputStream(new FileOutputStream(TRANSPORTS_FILE));
            Map<String, List<Integer>> seatData = new HashMap<>();
            for (Map.Entry<String, Transport> entry : transports.entrySet()) {
                seatData.put(entry.getKey(), entry.getValue().getAvailableSeats());
            }
            transportsOut.writeObject(seatData);
            transportsOut.close();
            
        } catch (IOException e) {
            System.err.println("⚠️  Error saving data: " + e.getMessage());
        }
    }
    
    // File I/O - Load data
    @SuppressWarnings("unchecked")
    private void loadData() {
        try {
            // Load tickets
            File ticketsFile = new File(TICKETS_FILE);
            if (ticketsFile.exists()) {
                ObjectInputStream ticketsIn = new ObjectInputStream(new FileInputStream(ticketsFile));
                tickets = (List<Ticket>) ticketsIn.readObject();
                ticketCounter = ticketsIn.readInt();
                ticketsIn.close();
            }
            
            // Load users
            File usersFile = new File(USERS_FILE);
            if (usersFile.exists()) {
                ObjectInputStream usersIn = new ObjectInputStream(new FileInputStream(usersFile));
                users = (Map<String, User>) usersIn.readObject();
                usersIn.close();
            }
            
            // Load transports (seat availability)
            File transportsFile = new File(TRANSPORTS_FILE);
            if (transportsFile.exists()) {
                ObjectInputStream transportsIn = new ObjectInputStream(new FileInputStream(transportsFile));
                Map<String, List<Integer>> seatData = (Map<String, List<Integer>>) transportsIn.readObject();
                for (Map.Entry<String, List<Integer>> entry : seatData.entrySet()) {
                    Transport transport = transports.get(entry.getKey());
                    if (transport != null) {
                        transport.setAvailableSeats(entry.getValue());
                    }
                }
                transportsIn.close();
            }
            
            System.out.println("✅ Data loaded successfully!");
            
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("⚠️  No previous data found or error loading data. Starting fresh!");
        }
    }
    
    // Get all users
    public Map<String, User> getAllUsers() {
        return users;
    }
}
