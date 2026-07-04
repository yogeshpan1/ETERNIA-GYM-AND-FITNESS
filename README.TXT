<div align="center">

# 🏋️ ETERNIA GYM AND FITNESS

### A Java Swing-Based Desktop Gym Management System

*A comprehensive desktop application for managing gym memberships, attendance, payments, loyalty rewards, and member records using Object-Oriented Programming principles.*

---

![Java](https://img.shields.io/badge/Java-17-orange)
![Swing](https://img.shields.io/badge/GUI-Java%20Swing-blue)
![OOP](https://img.shields.io/badge/OOP-Implemented-success)
![Platform](https://img.shields.io/badge/Platform-Desktop-lightgrey)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen)
![License](https://img.shields.io/badge/License-MIT-green)

</div>

---

# 📖 Overview

**ETERNIA GYM AND FITNESS** is a desktop-based Gym Management System developed using **Java** and **Java Swing**.

The application simplifies gym membership management by providing an intuitive graphical user interface that allows administrators to register members, manage memberships, track attendance, process payments, reward loyalty points, and maintain member records.

The project was designed using **Object-Oriented Programming (OOP)** principles and demonstrates concepts such as inheritance, encapsulation, abstraction, polymorphism, file handling, exception handling, collections, and event-driven programming.

---

# ✨ Features

## 👤 Member Registration

Register new gym members with complete personal information.

Each member record includes:

- Membership ID
- Full Name
- Address
- Contact Number
- Email Address
- Gender
- Date of Birth
- Membership Start Date

---

## 🏃 Regular Membership

Manage regular gym members with features including:

- Member Registration
- Membership Activation
- Membership Deactivation
- Attendance Tracking
- Loyalty Point Collection
- Membership Upgrade Eligibility
- Referral Source Management
- Membership Reversion

---

## 💎 Premium Membership

Premium members receive additional management capabilities including:

- Premium Plan Registration
- Personal Trainer Assignment
- Payment Tracking
- Discount Eligibility
- Premium Membership Reversion

---

## 📅 Attendance Management

Track every member visit.

Features include:

- Attendance Recording
- Automatic Attendance Counter
- Loyalty Point Updates
- Upgrade Eligibility Detection

---

## 🎁 Loyalty Rewards

Reward active members through a loyalty points system.

Features:

- Automatic Point Calculation
- Attendance-based Rewards
- Progress Tracking

---

## 📈 Membership Upgrade

Eligible regular members can upgrade their membership once attendance requirements are satisfied.

Upgrade process includes:

- Eligibility Validation
- Plan Selection
- Membership Update

---

## 💳 Payment Management

Manage membership payments with multiple payment methods.

Supports:

- Cash Payment
- Online Payment
- QR Code Payment

---

## 🏷 Discount Calculation

Premium members can calculate discounts based on membership rules.

The application automatically:

- Checks eligibility
- Calculates discount amount
- Displays payable amount

---

## 🔄 Membership Activation

Activate inactive memberships whenever required.

Features:

- Status Validation
- Instant Activation
- Membership State Update

---

## ⛔ Membership Deactivation

Temporarily deactivate memberships.

Useful for:

- Membership Suspension
- Temporary Leave
- Administrative Control

---

## 📂 File Management

Save and retrieve member information using local files.

Capabilities include:

- Save Member Records
- Read Existing Records
- Persistent Data Storage

---

## 🔍 Member Search

Quickly retrieve information using Membership ID.

Displays:

- Personal Information
- Membership Details
- Attendance
- Loyalty Points
- Membership Status

---

# 🖥 User Interface

The application provides an intuitive Java Swing graphical interface.

Main sections include:

```
Main Menu
│
├── Regular Member
├── Premium Member
├── Login Panel
│
├── Add Member
├── Display Member
├── Attendance
├── Upgrade Membership
├── Activate Membership
├── Deactivate Membership
├── Revert Membership
├── Payment
├── Discount Checker
├── Save Records
└── Read Records
```

---

# 🧠 Object-Oriented Programming Concepts

The project demonstrates core Object-Oriented Programming concepts.

## 🔹 Inheritance

```
GymMember
│
├── RegularMember
│
└── PremiumMember
```

The child classes inherit common functionality from the parent `GymMember` class while implementing their own specialized behaviors.

---

## 🔹 Encapsulation

Private and protected member variables are accessed using getters, setters, and controlled methods to ensure secure data management.

---

## 🔹 Polymorphism

Method overriding is used to provide different implementations for attendance tracking and membership behavior.

---

## 🔹 Abstraction

The abstract `GymMember` class defines the common structure and behaviors shared across all member types.

---

# 🛠 Technology Stack

| Technology | Purpose |
|------------|----------|
| Java | Core Programming Language |
| Java Swing | Desktop GUI |
| OOP | Software Design |
| ArrayList | Data Storage |
| File Handling | Persistent Storage |
| Exception Handling | Error Management |
| Event Handling | GUI Interaction |

---

# 📂 Project Structure

```
ETERNIA-GYM-AND-FITNESS
│
├── GymMember.java
├── RegularMember.java
├── PremiumMember.java
├── GymGUI.java
│
├── MemberDetails.txt
│
├── README.md
│
└── Screenshots
```

---

# 🚀 Getting Started

## Prerequisites

- Java JDK 17 or above
- VS Code / IntelliJ IDEA / Eclipse
- Git

---

## Installation

Clone the repository

```bash
git clone https://github.com/yogeshpan1/ETERNIA-GYM-AND-FITNESS.git
```

Move into the project directory

```bash
cd ETERNIA-GYM-AND-FITNESS
```

Compile the project

```bash
javac *.java
```

Run the application

```bash
java GymGUI
```

---

# 📸 Screenshots

Add screenshots here.

```
screenshots/

├── home.png
├── regular-member.png
├── premium-member.png
├── login.png
├── attendance.png
├── payment.png
├── qr-payment.png
├── display-member.png
```

---

# 🎯 Learning Outcomes

This project demonstrates practical knowledge of:

- Java Programming
- Object-Oriented Programming
- GUI Development
- Event-Driven Programming
- Collections Framework
- File Handling
- Exception Handling
- Software Design
- Desktop Application Development

---

# 🔮 Future Improvements

Potential future enhancements include:

- SQLite/MySQL Database Integration
- User Authentication
- Admin Dashboard
- Barcode/QR Member Check-in
- Membership Expiry Notifications
- Email Notifications
- Payment Gateway Integration
- Membership Analytics
- Multi-user Support
- Dark Mode
- Cloud Synchronization
- Printable Reports

---

# 🤝 Contributing

Contributions are welcome.

If you'd like to improve this project:

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push the branch
5. Open a Pull Request

Bug reports, feature requests, and suggestions are always appreciated.

---

# 📜 License

This project is licensed under the **MIT License**.

---

# 👨‍💻 Author

**Yogesh Pant**

BSc (Hons) Computing  
London Metropolitan University  
Islington College, Kathmandu

GitHub: https://github.com/yogeshpan1

---

<div align="center">

### 🏋️ Building Better Fitness Management Through Java

⭐ If you found this project interesting, consider giving it a star!

</div>
