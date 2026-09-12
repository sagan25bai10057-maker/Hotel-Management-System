package hotelmanagement;

import java.util.Scanner;

public class InputValidator {
    private final Scanner sc;

    public InputValidator(Scanner sc) { this.sc = sc; }

    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }

    public double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double x = Double.parseDouble(sc.nextLine().trim());
                if (x < 0) throw new NumberFormatException();
                return x;
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please enter a non-negative number.");
            }
        }
    }

    public String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Input cannot be empty.");
        }
    }

    public String readDate(String prompt) {
        while (true) {
            String s = readNonEmpty(prompt);
            if (s.matches("\\d{4}-\\d{2}-\\d{2}")) return s;
            System.out.println("Use date format YYYY-MM-DD.");
        }
    }
}
