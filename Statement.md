# Project Statement

## Hotel Management System

**Student Name:** Sagan Gangwar
**Registration No.:** 25BAI10057

---

## 1. Problem Statement

Managing hotel operations manually can be time-consuming and can lead to errors in maintaining room availability, guest records, reservations, and billing information.

The **Hotel Management System** provides a computerized solution for managing these activities through a Java-based console application.

The system allows hotel staff to manage rooms, register guests, create and cancel bookings, generate bills, and view hotel occupancy information.

---

## 2. Project Scope

The project focuses on the basic operational requirements of a hotel.

The system covers:

* Room management
* Guest management
* Booking management
* Booking cancellation
* Billing
* Hotel occupancy dashboard
* File-based data storage
* Input validation
* Error handling

The current version is a console-based application and uses CSV files for data persistence.

---

## 3. Target Users

The intended users of the system are:

1. Hotel administrators
2. Reception staff
3. Hotel employees
4. Small hotel operators

The application is designed to provide a simple interface that can be operated through a menu-driven console.

---

## 4. High-Level Features

### Room Management

The system maintains room information such as:

* Room number
* Room type
* Price
* Availability/status

### Guest Management

The system maintains guest information including:

* Guest ID
* Guest name
* Contact information
* Guest details

### Booking Management

The booking module allows users to:

* Create reservations
* Select available rooms
* Store booking details
* Cancel reservations
* Update room availability

### Billing

The billing module calculates:

* Room charges
* Additional service charges
* Tax
* Final payable amount

### Dashboard

The dashboard provides information about:

* Total rooms
* Available rooms
* Occupied rooms
* Hotel occupancy

---

## 5. Technical Approach

The application follows a modular object-oriented design.

The main classes include:

```text
Main
Room
Guest
Booking
Bill
Staff
FileManager
RoomManager
GuestManager
BookingManager
BillManager
ReportManager
InputValidator
```

The model classes represent hotel entities, while manager classes handle the corresponding operations.

`FileManager` provides file-based persistence using CSV files.

`InputValidator` is responsible for validating user input and reducing invalid data entry.

---

## 6. Data Storage

The application uses CSV files stored in the `data` directory.

```text
data/
├── rooms.csv
├── guests.csv
├── bookings.csv
├── bills.csv
└── staff.csv
```

This approach avoids requiring an external database server and makes the application easy to run for demonstration and academic purposes.

---

## 7. Expected Outcome

After implementation, the system should provide a functional hotel management application through which a user can:

1. View hotel rooms.
2. Add or manage rooms.
3. Register guests.
4. Create bookings.
5. Cancel bookings.
6. Generate bills.
7. View hotel occupancy.
8. Save and retrieve information from files.

---

## 8. Author Information

**Name:** Sagan Gangwar
**Registration No.:** 25BAI10057
**Project:** Hotel Management System
**Technology:** Java
