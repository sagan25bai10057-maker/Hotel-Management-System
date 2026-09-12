package hotelmanagement;

import java.util.*;

public class GuestManager {
    private final List<Guest> guests;
    private final FileManager fm;

    public GuestManager(FileManager fm) {
        this.fm = fm;
        guests = fm.read("guests.csv", Guest::fromCsv);
    }

    public int nextId() {
        return guests.stream().mapToInt(Guest::getGuestId).max().orElse(0) + 1;
    }

    public Guest add(String name, String phone, String email) {
        Guest g = new Guest(nextId(), name, phone, email);
        guests.add(g);
        save();
        return g;
    }

    public Guest find(int id) {
        for (Guest g : guests) if (g.getGuestId() == id) return g;
        return null;
    }

    public void showGuests() {
        System.out.println("\n--- GUEST LIST ---");
        if (guests.isEmpty()) System.out.println("No guests found.");
        for (Guest g : guests) System.out.println(g);
    }

    public void save() {
        fm.write("guests.csv", guests, Guest::toCsv);
    }
}
