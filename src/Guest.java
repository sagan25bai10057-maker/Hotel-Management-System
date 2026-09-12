package hotelmanagement;

public class Guest {
    private int guestId;
    private String name;
    private String phone;
    private String email;

    public Guest(int guestId, String name, String phone, String email) {
        this.guestId = guestId;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public int getGuestId() { return guestId; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }

    public String toCsv() {
        return guestId + "," + name.replace(",", " ") + "," + phone + "," + email;
    }

    public static Guest fromCsv(String line) {
        String[] p = line.split(",");
        return new Guest(Integer.parseInt(p[0]), p[1], p[2], p[3]);
    }

    @Override
    public String toString() {
        return String.format("Guest ID: %d | Name: %s | Phone: %s | Email: %s",
                guestId, name, phone, email);
    }
}
