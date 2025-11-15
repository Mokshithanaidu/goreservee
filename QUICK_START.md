# 🚀 Quick Start Guide - GoReserve

## ⚡ Super Simple - Just 2 Commands!

```bash
# Step 1: Make script executable (first time only)
chmod +x run.sh

# Step 2: Run the application
./run.sh
```

**That's all!** The script handles everything automatically! 🎉

---

## 📝 What It Does Automatically

✅ Compiles all Java files  
✅ Creates data directory  
✅ Runs the application  
✅ No complex setup needed  

---

## 📝 First Time Setup

### 1. Register a User
- Choose option 1: "Register New User"
- Enter your details
- **Save your User ID** - you'll need it to login

### 2. Explore Features
Try these in order:
1. View all available transports (Option 2)
2. View available seats (Option 6)
3. Book a ticket (Option 3)
4. View your bookings (Option 5)

---

## 💡 Sample Test Flow

```
1. Register User
   Name: John Doe
   Email: john@example.com
   Phone: 9876543210
   
2. Note User ID (e.g., USER0001)

3. View All Transports
   - See BUS001, BUS002, TRN001, etc.

4. Book a Ticket
   Transport ID: BUS001
   Seat Number: 5
   
5. View Booking
   - See your ticket details
   
6. View Available Seats
   Transport ID: BUS001
   - Notice seat 5 is now booked

7. Cancel Ticket
   Ticket ID: TKT001000
```

---

## 🐛 Troubleshooting

### Issue: "javac not found"
**Solution**: Install Java JDK
```bash
# Check if Java is installed
java -version
javac -version

# If not installed, download from:
# https://www.oracle.com/java/technologies/downloads/
```

### Issue: "Cannot find or load main class"
**Solution**: Make sure you're in the correct directory
```bash
# Run from the bin directory
cd bin
java com.reservation.TicketReservationApp
```

### Issue: Data not persisting
**Solution**: Check if data directory exists
```bash
# The application should create this automatically
ls -la data/
```

---

## 📊 Pre-loaded Sample Data

The application includes:
- **3 Buses** (BUS001, BUS002, BUS003)
- **3 Trains** (TRN001, TRN002, TRN003)

All routes between major Indian cities:
- Mumbai ↔ Pune ↔ Delhi ↔ Jaipur
- Bangalore ↔ Chennai ↔ Hyderabad ↔ Kolkata

---

## ✅ Feature Checklist

Test all features:
- [ ] Register new user
- [ ] Login with User ID
- [ ] Search transports by route
- [ ] View all transports
- [ ] Book a ticket
- [ ] View available seats
- [ ] View my bookings
- [ ] Cancel a ticket
- [ ] View profile
- [ ] Logout and login again
- [ ] Verify data persists after restart

---

## 🎓 Interview Talking Points

When presenting this project:

1. **OOP Concepts**
   - "I've used abstraction through the Transport abstract class"
   - "Bus and Train classes demonstrate inheritance and polymorphism"
   - "All data classes use encapsulation with private fields"

2. **Collections**
   - "I've used HashMap for O(1) lookups of users and transports"
   - "ArrayList manages the dynamic list of tickets"

3. **File I/O**
   - "Used ObjectOutputStream/ObjectInputStream for serialization"
   - "Data persists across application restarts"

4. **Design Patterns**
   - "Modular design with separation of concerns"
   - "Each class has a single responsibility"

5. **Scalability**
   - "Easy to add new transport types by extending Transport class"
   - "Can easily integrate with database using same structure"

---

**Enjoy coding! 🎉**
