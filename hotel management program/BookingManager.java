package hotelmanagement;

import java.util.*;

public class BookingManager {
    private final List<Booking> bookings;
    private final FileManager fm;
    private int nextId;

    public BookingManager(FileManager fm) {
        this.fm = fm;
        bookings = fm.read("bookings.csv", Booking::fromCsv);
        nextId = bookings.stream().mapToInt(Booking::getBookingId).max().orElse(0) + 1;
    }

    public Booking create(int guestId, Room room, String checkIn, String checkOut, int nights) {
        Booking b = new Booking(nextId++, guestId, room.getRoomNumber(), checkIn, checkOut, nights);
        bookings.add(b);
        room.setAvailable(false);
        return b;
    }

    public Booking find(int id) {
        for (Booking b : bookings) if (b.getBookingId() == id) return b;
        return null;
    }

    public void cancel(int id, RoomManager roomManager) {
        Booking b = find(id);
        if (b == null) {
            System.out.println("Booking not found.");
            return;
        }
        Room room = roomManager.find(b.getRoomNumber());
        if (room != null) room.setAvailable(true);
        bookings.remove(b);
        save();
        roomManager.save();
        System.out.println("Booking cancelled successfully.");
    }

    public void showBookings() {
        System.out.println("\n--- BOOKING LIST ---");
        if (bookings.isEmpty()) System.out.println("No bookings found.");
        for (Booking b : bookings) System.out.println(b);
    }

    public List<Booking> getBookings() { return bookings; }

    public void save() {
        fm.write("bookings.csv", bookings, Booking::toCsv);
    }
}
