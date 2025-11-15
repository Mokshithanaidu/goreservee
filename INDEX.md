# 📚 GoReserve - Complete File Index

## 📁 Project Structure

```
GoReserve/
│
├── src/com/reservation/          # Source code directory
│   ├── Transport.java            # Abstract base class (Abstraction)
│   ├── Bus.java                  # Concrete subclass (Inheritance)
│   ├── Train.java                # Concrete subclass (Inheritance)
│   ├── User.java                 # User data class (Encapsulation)
│   ├── Ticket.java               # Ticket data class (Encapsulation)
│   ├── ReservationSystem.java    # Core logic (Collections, File I/O)
│   └── TicketReservationApp.java # Main application (UI)
│
├── data/                          # Data persistence directory
│   ├── tickets.dat               # Serialized tickets (auto-generated)
│   ├── users.dat                 # Serialized users (auto-generated)
│   └── transports.dat            # Serialized transport data (auto-generated)
│
├── bin/                           # Compiled classes (auto-generated)
│   └── com/reservation/*.class
│
├── README.md                      # Main project documentation
├── QUICK_START.md                 # Quick start guide
├── PROJECT_SUMMARY.md             # Project summary for interviews
├── INTERVIEW_QA.md                # Interview questions & answers
├── ARCHITECTURE.md                # Architecture diagrams
├── INDEX.md                       # This file
│
├── run.sh                         # Bash script (macOS/Linux)
├── run.bat                        # Batch script (Windows)
└── .gitignore                     # Git ignore file
```

---

## 📄 File Descriptions

### Source Files (src/com/reservation/)

#### 1. **Transport.java** (Abstract Class)
- **Purpose**: Base class for all transport types
- **OOP Concepts**: Abstraction, Encapsulation
- **Key Features**:
  - Abstract methods: `calculatePrice()`, `getTransportType()`
  - Concrete methods: `bookSeat()`, `cancelSeat()`
  - Private fields with getters/setters
  - Seat availability management

#### 2. **Bus.java** (Concrete Class)
- **Purpose**: Bus-specific implementation
- **OOP Concepts**: Inheritance, Polymorphism
- **Key Features**:
  - Extends Transport
  - Overrides `calculatePrice()` with bus-specific logic
  - Bus type (AC, Non-AC, Sleeper)
  - Window seat pricing

#### 3. **Train.java** (Concrete Class)
- **Purpose**: Train-specific implementation
- **OOP Concepts**: Inheritance, Polymorphism
- **Key Features**:
  - Extends Transport
  - Overrides `calculatePrice()` with train-specific logic
  - Train class (1A, 2A, 3A, SL)
  - Lower berth pricing

#### 4. **User.java** (Data Class)
- **Purpose**: Encapsulate user information
- **OOP Concepts**: Encapsulation
- **Key Features**:
  - Private fields (userId, name, email, phone)
  - Public getters and setters
  - Implements Serializable
  - toString() for display

#### 5. **Ticket.java** (Data Class)
- **Purpose**: Encapsulate ticket information
- **OOP Concepts**: Encapsulation
- **Key Features**:
  - Private fields (ticketId, price, status, etc.)
  - Public getters and setters
  - Implements Serializable
  - Formatted ticket display

#### 6. **ReservationSystem.java** (Business Logic)
- **Purpose**: Core business logic and data management
- **OOP Concepts**: Collections, File I/O
- **Key Features**:
  - HashMap for users and transports
  - ArrayList for tickets
  - File persistence (save/load)
  - Booking and cancellation logic
  - Search functionality

#### 7. **TicketReservationApp.java** (Main Application)
- **Purpose**: User interface and menu system
- **Key Features**:
  - Menu-driven console interface
  - Scanner for user input
  - Input validation
  - Modular method design
  - User session management

---

## 📖 Documentation Files

#### 1. **README.md**
- Complete project overview
- Features list
- OOP concepts explanation
- Installation instructions
- Usage guide
- Sample data
- Interview highlights

#### 2. **QUICK_START.md**
- Fast setup instructions
- Manual compilation steps
- First-time user guide
- Sample test flow
- Troubleshooting tips
- Feature checklist

#### 3. **PROJECT_SUMMARY.md**
- Deliverables checklist
- Detailed OOP implementation
- Statistics and metrics
- Demo instructions
- Extension ideas
- Interview preparation checklist

#### 4. **INTERVIEW_QA.md**
- 18+ interview questions with detailed answers
- OOP concept questions
- Collections framework questions
- File I/O questions
- Design pattern questions
- Practical scenario questions
- Behavioral questions

#### 5. **ARCHITECTURE.md**
- Class hierarchy diagrams
- Application layer architecture
- Data flow diagrams
- Sequence diagrams
- Component interaction
- Memory structure
- SOLID principles application

#### 6. **INDEX.md** (This File)
- Complete file listing
- File descriptions
- Purpose of each component
- Quick reference guide

---

## 🔧 Build & Run Files

#### 1. **run.sh** (Bash Script)
- For macOS and Linux
- Compiles all Java files
- Creates bin directory
- Runs the application
- Error handling

#### 2. **run.bat** (Batch Script)
- For Windows
- Same functionality as run.sh
- Windows-compatible commands

---

## 🗃️ Data Files (Auto-generated)

#### 1. **data/tickets.dat**
- Binary file containing serialized tickets
- Created on first booking
- Updated on booking/cancellation

#### 2. **data/users.dat**
- Binary file containing serialized users
- Created on first registration
- Updated on new registration

#### 3. **data/transports.dat**
- Binary file containing seat availability
- Created on first booking
- Updated on booking/cancellation

---

## 📊 File Statistics

| Category | Files | Lines of Code (approx) |
|----------|-------|------------------------|
| Source Code | 7 | ~800 |
| Documentation | 6 | ~2000 |
| Build Scripts | 2 | ~40 |
| **Total** | **15** | **~2840** |

---

## 🎯 Quick Reference

### To Read First:
1. **README.md** - Understand the project
2. **QUICK_START.md** - Run the application
3. **PROJECT_SUMMARY.md** - Interview preparation

### Before Interview:
1. **INTERVIEW_QA.md** - Practice questions
2. **ARCHITECTURE.md** - Understand design
3. **Source files** - Review implementation

### During Development:
1. **Source files** - Implementation
2. **run.sh/run.bat** - Build & test
3. **README.md** - Reference

---

## 🔍 Finding Things Quickly

### Need to explain OOP?
→ **README.md** (Section: OOP Concepts Demonstrated)
→ **PROJECT_SUMMARY.md** (Section: OOP Concepts Implementation)

### Need to show code?
→ **src/com/reservation/** (All source files)

### Need architecture diagram?
→ **ARCHITECTURE.md** (Multiple diagrams)

### Need interview answers?
→ **INTERVIEW_QA.md** (18+ Q&A pairs)

### Need to run quickly?
→ **QUICK_START.md** (Step-by-step guide)

---

## 📝 File Modification Guide

### To add new transport type:
1. Create new class extending `Transport.java`
2. Implement abstract methods
3. Add sample data in `ReservationSystem.java`

### To add new feature:
1. Add method in `ReservationSystem.java` (business logic)
2. Add menu option in `TicketReservationApp.java` (UI)
3. Update documentation

### To change persistence:
1. Modify `saveData()` and `loadData()` in `ReservationSystem.java`
2. Keep the same public API
3. No changes needed elsewhere

---

## 📚 Documentation Map

```
Start Here
    ↓
README.md (Overview)
    ↓
QUICK_START.md (Run It)
    ↓
Play with Application
    ↓
PROJECT_SUMMARY.md (Understand Design)
    ↓
ARCHITECTURE.md (Visual Understanding)
    ↓
Review Source Code
    ↓
INTERVIEW_QA.md (Practice)
    ↓
Ready for Interview! 🎉
```

---

## 🎓 Learning Path

### Beginner:
1. Read README.md
2. Run the application
3. Understand basic flow

### Intermediate:
1. Study Transport.java (abstraction)
2. Study Bus/Train.java (inheritance)
3. Understand polymorphism in action

### Advanced:
1. Analyze ReservationSystem.java (collections, file I/O)
2. Study architecture patterns
3. Plan extensions and modifications

---

## 🚀 Deployment Checklist

- [ ] All source files compiled without errors
- [ ] Application runs successfully
- [ ] All features tested
- [ ] Documentation reviewed
- [ ] Interview questions practiced
- [ ] Demo prepared
- [ ] Can explain every file's purpose
- [ ] Can draw architecture from memory

---

**This index helps you navigate the entire project efficiently! 📖**
