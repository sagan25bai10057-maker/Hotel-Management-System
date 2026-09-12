package hotelmanagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileManager fm = new FileManager();
        RoomManager roomManager = new RoomManager(fm);
        GuestManager guestManager = new GuestManager(fm);
        BookingManager bookingManager = new BookingManager(fm);
        BillManager billManager = new BillManager(fm);
        ReportManager reportManager = new ReportManager();
        Scanner sc = new Scanner(System.in);
        InputValidator in = new InputValidator(sc);

        System.out.println("==========================================");
        System.out.println("       GRAND JAVA HOTEL MANAGEMENT");
        System.out.println("==========================================");

        boolean running = true;
        while (running) {
            System.out.println("\n1. Room Management");
            System.out.println("2. Guest Management");
            System.out.println("3. Booking / Reservation");
            System.out.println("4. Generate Bill");
            System.out.println("5. Hotel Dashboard");
            System.out.println("6. View All Bookings");
            System.out.println("7. Exit");

            int choice = in.readInt("Enter choice: ");

            switch (choice) {
                case 1:
                    roomManager.showRooms();
                    break;

                case 2:
                    System.out.println("\n1. Add Guest");
                    System.out.println("2. View Guests");
                    int gc = in.readInt("Enter choice: ");
                    if (gc == 1) {
                        String name = in.readNonEmpty("Name: ");
                        String phone = in.readNonEmpty("Phone: ");
                        String email = in.readNonEmpty("Email: ");
                        Guest g = guestManager.add(name, phone, email);
                        System.out.println("Guest created: " + g);
                    } else if (gc == 2) {
                        guestManager.showGuests();
                    } else {
                        System.out.println("Invalid option.");
                    }
                    break;

                case 3:
                    System.out.println("\n1. New Booking");
                    System.out.println("2. Cancel Booking");
                    int bc = in.readInt("Enter choice: ");

                    if (bc == 1) {
                        guestManager.showGuests();
                        int gid = in.readInt("Enter Guest ID: ");
                        Guest guest = guestManager.find(gid);
                        if (guest == null) {
                            System.out.println("Guest not found. Add guest first.");
                            break;
                        }

                        roomManager.showRooms();
                        int roomNo = in.readInt("Enter Room Number: ");
                        Room room = roomManager.findAvailable(roomNo);
                        if (room == null) {
                            System.out.println("Room not found or already occupied.");
                            break;
                        }

                        String checkIn = in.readDate("Check-in (YYYY-MM-DD): ");
                        String checkOut = in.readDate("Check-out (YYYY-MM-DD): ");
                        int nights = in.readInt("Number of nights: ");
                        if (nights <= 0) {
                            System.out.println("Nights must be greater than zero.");
                            break;
                        }

                        Booking b = bookingManager.create(gid, room, checkIn, checkOut, nights);
                        bookingManager.save();
                        roomManager.save();
                        System.out.println("Booking confirmed: " + b);
                    } else if (bc == 2) {
                        int bid = in.readInt("Enter Booking ID: ");
                        bookingManager.cancel(bid, roomManager);
                    } else {
                        System.out.println("Invalid option.");
                    }
                    break;

                case 4:
                    bookingManager.showBookings();
                    int bid = in.readInt("Enter Booking ID for billing: ");
                    Booking booking = bookingManager.find(bid);
                    if (booking == null) {
                        System.out.println("Booking not found.");
                        break;
                    }
                    Room billRoom = roomManager.find(booking.getRoomNumber());
                    double service = in.readDouble("Enter service charge: ");
                    Bill bill = billManager.generate(booking, billRoom, service);
                    System.out.println(bill.formatted());
                    break;

                case 5:
                    reportManager.showDashboard(roomManager, guestManager, bookingManager);
                    break;

                case 6:
                    bookingManager.showBookings();
                    break;

                case 7:
                    running = false;
                    System.out.println("Thank you for using Grand Java Hotel Management.");
                    break;

                default:
                    System.out.println("Invalid choice. Select 1-7.");
            }
        }
        sc.close();
    }
}
