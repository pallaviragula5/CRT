import java.io.*;
import java.util.Scanner;

public class BufferedReadWriteDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "buffered_output.txt";

        // Write to file using BufferedWriter
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            System.out.print("Enter text to write to file: ");
            String text = sc.nextLine();

            writer.write(text);
            writer.newLine();  // Adds a newline
            writer.write("This line was added using BufferedWriter.");
            System.out.println("Text written successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        // Read from file using BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("\n--- Reading from file ---");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        sc.close();
    }
}
