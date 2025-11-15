package com.reservation;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Main Application Class - Menu-driven console interface
 * Demonstrates modular design with Scanner for user input
 */
public class TicketReservationApp {
    private static ReservationSystem system;
    private static Scanner scanner;
    private static User currentUser;
    
    public static void main(String[] args) {
        system = new ReservationSystem();
        scanner = new Scanner(System.in);
        
        displayWelcome();
        
        // Main application loop
        boolean running = true;
        while (running) {
            if (currentUser == null) {
                running = showLoginMenu();
            } else {
                running = showMainMenu();
            }
        }
        
        scanner.close();
        System.out.println("\n👋 Thank you for using GoReserve! Goodbye!");
    }
    
    private static void displayWelcome() {
        System.out.println("\n");
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║                                            ║");
        System.out.println("║          🚌 🚂 GoReserve 🚂 🚌           ║");
        System.out.println("║                                            ║");
        System.out.println("║      Ticket Reservation System             ║");
        System.out.println("║                                            ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println();
    }
    
    private static boolean showLoginMenu() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("           LOGIN MENU");
        System.out.println("═══════════════════════════════════════");
        System.out.println("1. Register New User");
        System.out.println("2. Login with User ID");
        System.out.println("3. Exit");
        System.out.println("═══════════════════════════════════════");
        System.out.print("Enter your choice: ");
        
        int choice = getIntInput();
        
        switch (choice) {
            case 1:
                registerUser();
                break;
            case 2:
                loginUser();
                break;
            case 3:
                return false;
            default:
                System.out.println("❌ Invalid choice! Please try again.");
        }
        
        return true;
    }
    
    private static boolean showMainMenu() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("       MAIN MENU");
        System.out.println("═══════════════════════════════════════");
        System.out.println("Welcome, " + currentUser.getName() + "!");
        System.out.println("───────────────────────────────────────");
        System.out.println("1. 🔍 Search Transports");
        System.out.println("2. 📋 View All Available Transports");
        System.out.println("3. 🎫 Book a Ticket");
        System.out.println("4. ❌ Cancel a Ticket");
        System.out.println("5. 📊 View My Bookings");
        System.out.println("6. 💺 View Available Seats");
        System.out.println("7. 👤 View My Profile");
        System.out.println("8. 🚪 Logout");
        System.out.println("9. 🔚 Exit");
        System.out.println("═══════════════════════════════════════");
        System.out.print("Enter your choice: ");
        
        int choice = getIntInput();
        
        switch (choice) {
            case 1:
                searchTransports();
                break;
            case 2:
                viewAllTransports();
                break;
            case 3:
                bookTicket();
                break;
            case 4:
                cancelTicket();
                break;
            case 5:
                viewMyBookings();
                break;
            case 6:
                viewAvailableSeats();
                break;
            case 7:
                viewProfile();
                break;
            case 8:
                currentUser = null;
                System.out.println("✅ Logged out successfully!");
                break;
            case 9:
                return false;
            default:
                System.out.println("❌ Invalid choice! Please try again.");
        }
        
        return true;
    }
    
    private static void registerUser() {
        System.out.println("\n─── Register New User ───");
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter your phone: ");
        String phone = scanner.nextLine();
        
        User user = system.registerUser(name, email, phone);
        System.out.println("\n✅ Registration successful!");
        System.out.println("Your User ID: " + user.getUserId());
        System.out.println("Please remember this ID for login.");
        
        currentUser = user;
    }
    
    private static void loginUser() {
        System.out.println("\n─── Login ───");
        System.out.print("Enter your User ID: ");
        String userId = scanner.nextLine();
        
        User user = system.getUser(userId);
        if (user != null) {
            currentUser = user;
            System.out.println("✅ Login successful! Welcome, " + user.getName());
        } else {
            System.out.println("❌ User not found! Please check your User ID.");
            System.out.println("💡 Hint: You can view all registered users by typing 'SHOW_USERS'");
            System.out.print("Enter 'SHOW_USERS' or press Enter to continue: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("SHOW_USERS")) {
                showAllUsers();
            }
        }
    }
    
    private static void showAllUsers() {
        System.out.println("\n─── Registered Users ───");
        Map<String, User> users = system.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("No users registered yet.");
        } else {
            for (User user : users.values()) {
                System.out.println("• " + user.getUserId() + " - " + user.getName());
            }
        }
    }
    
    private static void searchTransports() {
        System.out.println("\n─── Search Transports ───");
        System.out.print("Enter source city: ");
        String source = scanner.nextLine();
        
        System.out.print("Enter destination city: ");
        String destination = scanner.nextLine();
        
        List<Transport> results = system.searchTransports(source, destination);
        
        if (results.isEmpty()) {
            System.out.println("\n❌ No transports found for the given route.");
        } else {
            System.out.println("\n✅ Available Transports:");
            System.out.println("─────────────────────────────────────────────────────────────────");
            for (Transport transport : results) {
                System.out.println(transport);
                System.out.println("─────────────────────────────────────────────────────────────────");
            }
        }
    }
    
    private static void viewAllTransports() {
        System.out.println("\n─── All Available Transports ───");
        List<Transport> transports = system.getAllTransports();
        
        System.out.println("─────────────────────────────────────────────────────────────────");
        for (Transport transport : transports) {
            System.out.println(transport);
            System.out.println("─────────────────────────────────────────────────────────────────");
        }
    }
    
    private static void bookTicket() {
        System.out.println("\n─── Book a Ticket ───");
        
        viewAllTransports();
        
        System.out.print("\nEnter Transport ID: ");
        String transportId = scanner.nextLine().toUpperCase();
        
        System.out.print("Enter Seat Number: ");
        int seatNumber = getIntInput();
        
        Ticket ticket = system.bookTicket(currentUser.getUserId(), transportId, seatNumber);
        
        if (ticket != null) {
            System.out.println(ticket);
        }
    }
    
    private static void cancelTicket() {
        System.out.println("\n─── Cancel a Ticket ───");
        
        viewMyBookings();
        
        System.out.print("\nEnter Ticket ID to cancel: ");
        String ticketId = scanner.nextLine().toUpperCase();
        
        system.cancelTicket(ticketId);
    }
    
    private static void viewMyBookings() {
        System.out.println("\n─── My Bookings ───");
        List<Ticket> bookings = system.getUserBookings(currentUser.getUserId());
        
        if (bookings.isEmpty()) {
            System.out.println("📭 No bookings found.");
        } else {
            for (Ticket ticket : bookings) {
                System.out.println(ticket);
            }
            System.out.println("Total Bookings: " + bookings.size());
        }
    }
    
    private static void viewAvailableSeats() {
        System.out.println("\n─── View Available Seats ───");
        
        viewAllTransports();
        
        System.out.print("\nEnter Transport ID: ");
        String transportId = scanner.nextLine().toUpperCase();
        
        system.viewAvailableSeats(transportId);
    }
    
    private static void viewProfile() {
        System.out.println("\n─── My Profile ───");
        System.out.println(currentUser);
        
        List<Ticket> bookings = system.getUserBookings(currentUser.getUserId());
        long confirmedBookings = bookings.stream()
            .filter(t -> t.getStatus().equals("CONFIRMED"))
            .count();
        
        System.out.println("\n📊 Booking Statistics:");
        System.out.println("Total Bookings: " + bookings.size());
        System.out.println("Active Bookings: " + confirmedBookings);
    }
    
    private static int getIntInput() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("❌ Invalid input! Please enter a number: ");
            }
        }
    }
}
