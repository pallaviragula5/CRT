import java.io.*;
import java.util.Scanner;

public class FileWriteRead {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "myfile.txt";

        // === Write to file ===
        try {
            FileWriter writer = new FileWriter(fileName);
            
            System.out.print("Enter text to write into the file: ");
            String userInput = sc.nextLine();

            writer.write(userInput);
            writer.close();

            System.out.println("Text successfully written to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing: " + e.getMessage());
        }

        // === Read from file ===
        try {
            FileReader reader = new FileReader(fileName);
            System.out.println("\nReading content from " + fileName + ":");

            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading: " + e.getMessage());
        }

        sc.close();
    }
}
