package hotelmanagement;

public class Room {
    private int roomNumber;
    private String type;
    private double pricePerNight;
    private boolean available;

    public Room(int roomNumber, String type, double pricePerNight, boolean available) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.available = available;
    }

    public int getRoomNumber() { return roomNumber; }
    public String getType() { return type; }
    public double getPricePerNight() { return pricePerNight; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public String toCsv() {
        return roomNumber + "," + type + "," + pricePerNight + "," + available;
    }

    public static Room fromCsv(String line) {
        String[] p = line.split(",");
        return new Room(Integer.parseInt(p[0]), p[1], Double.parseDouble(p[2]), Boolean.parseBoolean(p[3]));
    }

    @Override
    public String toString() {
        return String.format("Room %-4d | %-10s | ₹%.2f/night | %s",
                roomNumber, type, pricePerNight, available ? "Available" : "Occupied");
    }
}
