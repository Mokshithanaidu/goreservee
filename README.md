# 🚌 🚂 GoReserve - Ticket Reservation System

A comprehensive **Core Java Console Application** demonstrating all major Object-Oriented Programming concepts including **Encapsulation**, **Inheritance**, **Polymorphism**, **Abstraction**, **File Handling**, and **Collections Framework**.

---

## 📋 Project Overview

This is a **menu-driven console application** for booking bus and train tickets. Users can register, search for transports, book tickets, cancel tickets, and view their booking history. All data is persisted using Java's file I/O mechanisms.

---

## ✨ Features

1. **User Management**
   - Register new users
   - Login with User ID
   - View user profile

2. **Transport Search & Display**
   - Search transports by source and destination
   - View all available transports
   - View available seats for specific transport

3. **Ticket Booking**
   - Book tickets for Bus or Train
   - Dynamic pricing based on seat number and transport type
   - Automatic seat allocation

4. **Ticket Cancellation**
   - Cancel confirmed tickets
   - Automatic seat release

5. **Booking Management**
   - View all bookings for a user
   - Show booking summary with statistics
   - Track booking status (CONFIRMED/CANCELLED)

6. **Data Persistence**
   - Save all data using File I/O
   - Load previous data on application startup
   - Maintain state across sessions

---

## 🎯 OOP Concepts Demonstrated

### 1. **Encapsulation**
- **Classes**: `User`, `Ticket`, `Transport`
- Private fields with public getters/setters
- Data hiding and controlled access
- Example:
  ```java
  private String userId;
  private String name;
  
  public String getUserId() { return userId; }
  public void setUserId(String userId) { this.userId = userId; }
  ```

### 2. **Inheritance**
- **Parent Class**: `Transport` (abstract)
- **Child Classes**: `Bus`, `Train`
- Code reuse through inheritance
- Example:
  ```java
  public class Bus extends Transport { ... }
  public class Train extends Transport { ... }
  ```

### 3. **Polymorphism**
- **Method Overriding**: `calculatePrice()`, `getTransportType()`
- Runtime polymorphism with different implementations
- Example:
  ```java
  // In Bus class
  @Override
  public double calculatePrice(int seatNumber) {
      // Bus-specific pricing logic
  }
  
  // In Train class
  @Override
  public double calculatePrice(int seatNumber) {
      // Train-specific pricing logic
  }
  ```

### 4. **Abstraction**
- **Abstract Class**: `Transport`
- **Abstract Methods**: `calculatePrice()`, `getTransportType()`
- Hide implementation details, show only essential features
- Example:
  ```java
  public abstract class Transport {
      public abstract double calculatePrice(int seatNumber);
      public abstract String getTransportType();
  }
  ```

### 5. **Collections Framework**
- **ArrayList**: Store tickets dynamically
- **HashMap**: Store transports and users with key-value pairs
- Efficient data management and retrieval
- Example:
  ```java
  private Map<String, Transport> transports;
  private Map<String, User> users;
  private List<Ticket> tickets;
  ```

### 6. **File Handling (I/O)**
- **ObjectOutputStream**: Save objects to files
- **ObjectInputStream**: Read objects from files
- Data persistence across application sessions
- Example:
  ```java
  ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("tickets.dat"));
  out.writeObject(tickets);
  ```

---

## 📁 Project Structure

```
GoReserve/
│
├── src/
│   └── com/
│       └── reservation/
│           ├── Transport.java           # Abstract base class
│           ├── Bus.java                 # Concrete subclass
│           ├── Train.java               # Concrete subclass
│           ├── User.java                # Encapsulated user class
│           ├── Ticket.java              # Encapsulated ticket class
│           ├── ReservationSystem.java   # Core business logic
│           └── TicketReservationApp.java # Main application
│
├── data/                                 # Data persistence directory
│   ├── tickets.dat
│   ├── users.dat
│   └── transports.dat
│
└── README.md                             # Project documentation
```

---

## 🚀 How to Run

### ⚡ Super Simple Way (Recommended)

```bash
# Step 1: Make script executable (first time only)
chmod +x run.sh

# Step 2: Run
./run.sh
```

**That's it!** Everything is automated! 🎉

### 📋 Manual Way (If you prefer)

```bash
# Compile
javac -d . src/com/reservation/*.java

# Run
java com.reservation.TicketReservationApp
```

**Note**: The application automatically creates the `data/` directory for file storage.

---

## 🎮 Usage Guide

### 1. **First Time Users**
   - Select "Register New User" from login menu
   - Enter your details (name, email, phone)
   - Note your User ID for future logins

### 2. **Login**
   - Select "Login with User ID"
   - Enter your User ID

### 3. **Search & Book**
   - Choose "Search Transports" or "View All Available Transports"
   - Note the Transport ID and available seats
   - Select "Book a Ticket"
   - Enter Transport ID and Seat Number

### 4. **Manage Bookings**
   - View "My Bookings" to see all tickets
   - Cancel tickets using Ticket ID
   - Check available seats before booking

---

## 📊 Sample Data

The application comes pre-loaded with:

### **Buses**
- **BUS001**: Mumbai → Pune (AC, 40 seats)
- **BUS002**: Delhi → Jaipur (Sleeper, 35 seats)
- **BUS003**: Bangalore → Chennai (Non-AC, 45 seats)

### **Trains**
- **TRN001**: Mumbai → Delhi (3A Class, 72 seats)
- **TRN002**: Kolkata → Chennai (2A Class, 80 seats)
- **TRN003**: Bangalore → Hyderabad (SL Class, 60 seats)

---

## 💡 Interview Highlights

### **Why This Project Stands Out:**

1. **Complete OOP Coverage**: Demonstrates all four pillars of OOP (Encapsulation, Inheritance, Polymorphism, Abstraction)

2. **Real-World Application**: Mimics actual ticket booking systems like RedBus or IRCTC

3. **Data Persistence**: Uses File I/O for saving and loading data

4. **Collections Mastery**: Implements ArrayList and HashMap effectively

5. **Clean Code**: Modular design with separation of concerns

6. **User Experience**: Menu-driven interface with clear navigation

7. **Error Handling**: Validates user inputs and handles edge cases

8. **Scalability**: Easy to extend with new transport types (Flight, Metro, etc.)

---

## 🔧 Technical Details

### **Key Classes & Responsibilities**

| Class | Responsibility | OOP Concept |
|-------|---------------|-------------|
| `Transport` | Abstract base for all transports | Abstraction |
| `Bus` | Concrete implementation for buses | Inheritance, Polymorphism |
| `Train` | Concrete implementation for trains | Inheritance, Polymorphism |
| `User` | User information management | Encapsulation |
| `Ticket` | Ticket details management | Encapsulation |
| `ReservationSystem` | Business logic & data management | Collections, File I/O |
| `TicketReservationApp` | User interface & menu | Scanner, Modular Design |

---

## 🎯 Learning Outcomes

After studying this project, you will understand:

- ✅ How to design class hierarchies using inheritance
- ✅ How to implement abstract classes and methods
- ✅ How to achieve polymorphism through method overriding
- ✅ How to encapsulate data with private fields and public methods
- ✅ How to use Collections (ArrayList, HashMap) for data storage
- ✅ How to implement file I/O for data persistence
- ✅ How to build menu-driven console applications
- ✅ How to structure a real-world Java project

---

## 🚀 Future Enhancements

- Add more transport types (Flight, Metro)
- Implement payment gateway integration
- Add user authentication (password)
- Generate PDF tickets
- Implement seat selection UI
- Add admin panel for managing transports
- Database integration (JDBC)

---

## 📝 License

This project is created for educational purposes.

---

## 👨‍💻 Author

Created as a demonstration of Core Java concepts for interview preparation.

---

**Happy Coding! 🎉**
