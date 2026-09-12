package hotelmanagement;

public class Bill {
    private int billId;
    private int bookingId;
    private double roomCharge;
    private double serviceCharge;
    private double tax;
    private double total;

    public Bill(int billId, int bookingId, double roomCharge,
                double serviceCharge, double tax) {
        this.billId = billId;
        this.bookingId = bookingId;
        this.roomCharge = roomCharge;
        this.serviceCharge = serviceCharge;
        this.tax = tax;
        this.total = roomCharge + serviceCharge + tax;
    }

    public int getBillId() { return billId; }
    public double getTotal() { return total; }

    public String toCsv() {
        return billId + "," + bookingId + "," + roomCharge + "," +
               serviceCharge + "," + tax + "," + total;
    }

    public static Bill fromCsv(String line) {
        String[] p = line.split(",");
        Bill b = new Bill(Integer.parseInt(p[0]), Integer.parseInt(p[1]),
                Double.parseDouble(p[2]), Double.parseDouble(p[3]), Double.parseDouble(p[4]));
        return b;
    }

    public String formatted() {
        return String.format(
                "\n========== HOTEL BILL ==========\n" +
                "Bill ID       : %d\n" +
                "Booking ID    : %d\n" +
                "Room Charge   : ₹%.2f\n" +
                "Service Charge: ₹%.2f\n" +
                "Tax (12%%)     : ₹%.2f\n" +
                "TOTAL         : ₹%.2f\n" +
                "================================\n",
                billId, bookingId, roomCharge, serviceCharge, tax, total);
    }
}
