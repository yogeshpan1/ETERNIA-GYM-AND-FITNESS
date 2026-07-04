<div align="center">

# 🏋️ ETERNIA GYM AND FITNESS

### A Java Swing-Based Desktop Gym Management System

*A comprehensive desktop application for managing gym memberships, attendance, payments, loyalty rewards, and member records using Object-Oriented Programming principles.*

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)
![Swing](https://img.shields.io/badge/GUI-Java%20Swing-blue?style=for-the-badge)
![OOP](https://img.shields.io/badge/OOP-Implemented-success?style=for-the-badge)
![Platform](https://img.shields.io/badge/Platform-Desktop-lightgrey?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

</div>

---

# 📖 Overview

**ETERNIA GYM AND FITNESS** is a desktop-based Gym Management System developed using **Java** and **Java Swing**.

The application provides an intuitive graphical user interface for managing gym members, memberships, attendance, payments, loyalty rewards, and member records.

The project demonstrates the practical implementation of **Object-Oriented Programming (OOP)** concepts including **Inheritance**, **Encapsulation**, **Polymorphism**, and **Abstraction**, along with Java Swing GUI development, event handling, collections, exception handling, and file handling.

---

# ✨ Features

## 👤 Member Management

- Register new members
- Update member details
- Display all registered members
- Search members
- Remove member records

---

## 🏃 Regular Membership

- Register Regular Members
- Attendance Tracking
- Loyalty Points
- Membership Upgrade
- Membership Revert
- Activate Membership
- Deactivate Membership

---

## 💎 Premium Membership

- Register Premium Members
- Premium Plan Management
- Personal Trainer Support
- Discount Calculation
- Payment Tracking
- Membership Revert

---

## 📅 Attendance Management

- Record attendance
- Automatically update attendance count
- Calculate loyalty points
- Track member activity

---

## 💳 Payment System

Supports:

- Cash Payment
- Online Payment
- QR Payment

---

## 🎁 Loyalty Rewards

Automatically rewards members based on attendance.

Features include:

- Loyalty Point Calculation
- Attendance Rewards
- Membership Upgrade Eligibility

---

## 💾 File Handling

- Save member records
- Load saved records
- Persistent storage using text files

---

## ⚠ Exception Handling

The application validates user input and handles invalid data gracefully using Java Exception Handling.

---

# 🖥 User Interface

The application contains separate interfaces for different operations.

```
Main Window
│
├── Add Regular Member
├── Add Premium Member
├── Activate Membership
├── Deactivate Membership
├── Attendance
├── Upgrade Plan
├── Payment
├── Calculate Discount
├── Display Members
├── Save Records
└── Read Records
```

---

# 🧠 Object-Oriented Programming

The application follows an Object-Oriented design.

### Inheritance

```
GymMember
│
├── RegularMember
└── PremiumMember
```

---

### Encapsulation

Private variables are accessed using getter and setter methods, ensuring secure data management.

---

### Polymorphism

Methods are overridden where necessary to provide different implementations for Regular and Premium members.

---

### Abstraction

The parent class defines the common behaviour shared by all member types while allowing subclasses to implement specialized functionality.

---

# 🛠 Technology Stack

| Technology | Purpose |
|------------|----------|
| Java | Core Programming Language |
| Java Swing | GUI Development |
| OOP | Software Design |
| ArrayList | Data Storage |
| File Handling | Save & Load Data |
| Exception Handling | Error Handling |
| Event Handling | GUI Interaction |

---

# 📂 Project Structure

```text
ETERNIA-GYM-AND-FITNESS
│
├── GymMember.java
├── RegularMember.java
├── PremiumMember.java
├── GymGUI.java
├── README.md
├── assets
│   ├── screenshots
│   └── icons
└── data
```

---

# 🚀 Getting Started

## Prerequisites

- Java JDK 17 or above
- Visual Studio Code / IntelliJ IDEA / Eclipse

---

## Clone the Repository

```bash
git clone https://github.com/yogeshpan1/ETERNIA-GYM-AND-FITNESS.git
```

---

## Navigate to the Project

```bash
cd ETERNIA-GYM-AND-FITNESS
```

---

## Compile

```bash
javac *.java
```

---

## Run

```bash
java GymGUI
```

---


# 🎯 Learning Outcomes

This project demonstrates:

- Java Programming
- Java Swing GUI Development
- Object-Oriented Programming
- Event-Driven Programming
- Collections Framework
- Exception Handling
- File Handling
- Desktop Application Development

---

# 🔮 Future Improvements

- Database Integration (MySQL / SQLite)
- User Authentication
- Admin Dashboard
- QR Code Check-In
- Email Notifications
- Membership Expiry Reminder
- Payment Gateway Integration
- Analytics Dashboard
- Cloud Backup
- Dark Mode

---

# 🤝 Contributing

Contributions are welcome.

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to your branch
5. Open a Pull Request

---


# 👨‍💻 Author

**Yogesh Pant**

🎓 BSc (Hons) Computing  
🏛️ Islington College, Kathmandu  
🎓 London Metropolitan University

GitHub: **https://github.com/yogeshpan1**

---

<div align="center">

### ⭐ If you found this project useful, consider giving it a star!

Made with ❤️ using Java

</div>
