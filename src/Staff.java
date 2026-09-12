package hotelmanagement;

public class Staff {
    private int staffId;
    private String name;
    private String role;

    public Staff(int staffId, String name, String role) {
        this.staffId = staffId;
        this.name = name;
        this.role = role;
    }

    public String toCsv() {
        return staffId + "," + name.replace(",", " ") + "," + role;
    }

    public static Staff fromCsv(String line) {
        String[] p = line.split(",");
        return new Staff(Integer.parseInt(p[0]), p[1], p[2]);
    }

    @Override
    public String toString() {
        return "Staff ID: " + staffId + " | " + name + " | Role: " + role;
    }
}
