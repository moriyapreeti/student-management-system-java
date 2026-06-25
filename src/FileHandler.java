import java.io.*;
import java.util.*;

class FileHandler {
    static final String FILE_NAME = "students.txt";

    static void saveToFile(List<Student> students) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                bw.write(s.toString());
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error saving file");
        }
    }

    static List<Student> loadFromFile() {
        List<Student> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                list.add(new Student(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2])));
            }
        } catch (Exception e) {
            System.out.println("No file found, starting fresh...");
        }

        return list;
    }
}
