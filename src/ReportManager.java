package hotelmanagement;

public class ReportManager {
    public void showDashboard(RoomManager rm, GuestManager gm, BookingManager bm) {
        int total = rm.getRooms().size();
        int available = 0;
        for (Room r : rm.getRooms()) if (r.isAvailable()) available++;
        int occupied = total - available;

        System.out.println("\n========== HOTEL DASHBOARD ==========");
        System.out.println("Total Rooms     : " + total);
        System.out.println("Available Rooms : " + available);
        System.out.println("Occupied Rooms   : " + occupied);
        System.out.println("Registered Guests: " + "Use Guest List");
        System.out.println("Active Bookings  : " + bm.getBookings().size());
        System.out.println("Occupancy Rate   : " +
                (total == 0 ? "0%" : String.format("%.2f%%", occupied * 100.0 / total)));
        System.out.println("=====================================");
    }
}
