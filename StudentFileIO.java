import java.io.*;
import java.util.Scanner;

class Student {
    private int rollNo;
    private String name;
    private double marks;

    public Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    // Convert student data to a single line for file storage
    public String toFileString() {
        return rollNo + "," + name + "," + marks;
    }

    // Convert a line from the file back to a Student object
    public static Student fromFileString(String line) {
        String[] parts = line.split(",");
        int roll = Integer.parseInt(parts[0]);
        String name = parts[1];
        double marks = Double.parseDouble(parts[2]);
        return new Student(roll, name, marks);
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Marks: " + marks;
    }
}

public class StudentFileIO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "students.txt";

        // === Writing Student Data to File ===
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            System.out.print("How many students? ");
            int n = sc.nextInt();
            sc.nextLine(); // consume newline

            for (int i = 0; i < n; i++) {
                System.out.println("\nEnter details for student " + (i + 1));
                System.out.print("Roll No: ");
                int rollNo = sc.nextInt();
                sc.nextLine(); // consume newline

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Marks: ");
                double marks = sc.nextDouble();
                sc.nextLine(); // consume newline

                Student s = new Student(rollNo, name, marks);
                writer.write(s.toFileString());
                writer.newLine();
            }

            System.out.println("\nStudent details written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        // === Reading Student Data from File ===
        System.out.println("\n--- Reading Students from File ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Student s = Student.fromFileString(line);
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        sc.close();
    }
}
