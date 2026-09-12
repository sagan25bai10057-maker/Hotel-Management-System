# Design Notes

## Architecture
Presentation/Menu -> Manager Layer -> Model Classes -> FileManager -> CSV Storage

## Major Modules
1. Room Management
2. Guest Management
3. Booking/Reservation
4. Billing
5. Reporting/Dashboard
6. Persistence and Validation

## OOP Concepts
- Encapsulation: private fields with public methods
- Constructors: initialize model objects
- Classes/objects: Room, Guest, Booking, Bill, Staff
- Methods: operations are separated into manager classes
- Collections: ArrayList stores runtime records
- Exception handling: invalid numeric input and file I/O
- File handling: CSV persistence
- Control flow: if/else, switch, loops

## Design Decision
CSV storage was selected to keep the project easy to run without installing a database. This makes the project self-contained while still demonstrating persistent storage.
