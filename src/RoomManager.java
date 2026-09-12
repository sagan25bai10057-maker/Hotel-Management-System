package hotelmanagement;

import java.util.*;

public class RoomManager {
    private final List<Room> rooms;
    private final FileManager fm;

    public RoomManager(FileManager fm) {
        this.fm = fm;
        rooms = fm.read("rooms.csv", Room::fromCsv);
        if (rooms.isEmpty()) {
            rooms.add(new Room(101, "Single", 1800, true));
            rooms.add(new Room(102, "Single", 1800, true));
            rooms.add(new Room(201, "Double", 2800, true));
            rooms.add(new Room(202, "Double", 2800, true));
            rooms.add(new Room(301, "Deluxe", 4200, true));
            rooms.add(new Room(302, "Suite", 6500, true));
            save();
        }
    }

    public List<Room> getRooms() { return rooms; }

    public void showRooms() {
        System.out.println("\n--- ROOM LIST ---");
        for (Room r : rooms) System.out.println(r);
    }

    public Room findAvailable(int roomNumber) {
        for (Room r : rooms)
            if (r.getRoomNumber() == roomNumber && r.isAvailable()) return r;
        return null;
    }

    public Room find(int roomNumber) {
        for (Room r : rooms) if (r.getRoomNumber() == roomNumber) return r;
        return null;
    }

    public void save() {
        fm.write("rooms.csv", rooms, Room::toCsv);
    }
}
