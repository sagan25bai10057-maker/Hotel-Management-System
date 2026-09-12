package hotelmanagement;

import java.io.*;
import java.util.*;
import java.util.function.Function;

public class FileManager {
    private final String dataDir = "data";

    public FileManager() {
        File dir = new File(dataDir);
        if (!dir.exists()) dir.mkdirs();
    }

    public <T> List<T> read(String fileName, Function<String, T> parser) {
        List<T> list = new ArrayList<>();
        File file = new File(dataDir, fileName);
        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) list.add(parser.apply(line));
            }
        } catch (IOException | RuntimeException e) {
            System.out.println("Data read error: " + e.getMessage());
        }
        return list;
    }

    public <T> void write(String fileName, List<T> list, Function<T, String> serializer) {
        File file = new File(dataDir, fileName);
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            for (T item : list) pw.println(serializer.apply(item));
        } catch (IOException e) {
            System.out.println("Data write error: " + e.getMessage());
        }
    }
}
