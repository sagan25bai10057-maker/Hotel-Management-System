package hotelmanagement;

import java.util.*;

public class BillManager {
    private final List<Bill> bills;
    private final FileManager fm;

    public BillManager(FileManager fm) {
        this.fm = fm;
        bills = fm.read("bills.csv", Bill::fromCsv);
    }

    public int nextId() {
        return bills.stream().mapToInt(Bill::getBillId).max().orElse(0) + 1;
    }

    public Bill generate(Booking booking, Room room, double serviceCharge) {
        double roomCharge = booking.getNights() * room.getPricePerNight();
        double tax = (roomCharge + serviceCharge) * 0.12;
        Bill bill = new Bill(nextId(), booking.getBookingId(), roomCharge, serviceCharge, tax);
        bills.add(bill);
        save();
        return bill;
    }

    public void save() {
        fm.write("bills.csv", bills, Bill::toCsv);
    }
}
