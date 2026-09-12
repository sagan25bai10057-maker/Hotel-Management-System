package hotelmanagement;

public class Booking {
    private int bookingId;
    private int guestId;
    private int roomNumber;
    private String checkIn;
    private String checkOut;
    private int nights;

    public Booking(int bookingId, int guestId, int roomNumber,
                   String checkIn, String checkOut, int nights) {
        this.bookingId = bookingId;
        this.guestId = guestId;
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.nights = nights;
    }

    public int getBookingId() { return bookingId; }
    public int getGuestId() { return guestId; }
    public int getRoomNumber() { return roomNumber; }
    public String getCheckIn() { return checkIn; }
    public String getCheckOut() { return checkOut; }
    public int getNights() { return nights; }

    public String toCsv() {
        return bookingId + "," + guestId + "," + roomNumber + "," +
               checkIn + "," + checkOut + "," + nights;
    }

    public static Booking fromCsv(String line) {
        String[] p = line.split(",");
        return new Booking(Integer.parseInt(p[0]), Integer.parseInt(p[1]),
                Integer.parseInt(p[2]), p[3], p[4], Integer.parseInt(p[5]));
    }

    @Override
    public String toString() {
        return String.format("Booking #%d | Guest %d | Room %d | %s to %s | %d night(s)",
                bookingId, guestId, roomNumber, checkIn, checkOut, nights);
    }
}
