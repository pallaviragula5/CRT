import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReadWriteDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "output.txt";

        // Write to file
        try {
            System.out.print("Enter text to write to file: ");
            String text = sc.nextLine();

            FileWriter writer = new FileWriter(fileName);
            writer.write(text);
            writer.close();
            System.out.println("Text written to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Read from file
        try {
            FileReader reader = new FileReader(fileName);
            System.out.println("\n--- Reading from file ---");

            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        sc.close();
    }
}
