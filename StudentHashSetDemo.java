import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

class Student {
    private int rollNumber;
    private String name;

    // Constructor
    public Student(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    // Getters
    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    // Override equals() and hashCode()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student other = (Student) obj;
        return rollNumber == other.rollNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNumber);
    }

    // To display student details
    @Override
    public String toString() {
        return "Roll No: " + rollNumber + ", Name: " + name;
    }
}

public class StudentHashSetDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Student> studentSet = new HashSet<>();

        System.out.print("How many students do you want to add? ");
        int count = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < count; i++) {
            System.out.print("Enter roll number: ");
            int roll = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            Student s = new Student(roll, name);
            if (!studentSet.add(s)) {
                System.out.println("Student with roll number " + roll + " already exists. Skipping...");
            }
        }

        System.out.println("\n--- Student List (No Duplicates) ---");
        for (Student s : studentSet) {
            System.out.println(s);
        }

        sc.close();
    }
}
