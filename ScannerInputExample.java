import java.util.Scanner;

public class ScannerInputExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read a string (one word)
        System.out.print("Enter your name: ");
        String name = sc.next(); // reads a single word
        System.out.println("Hello, " + name + "!");

        // Read an integer
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        System.out.println("You are " + age + " years old.");

        // Read a double
        System.out.print("Enter your marks: ");
        double marks = sc.nextDouble();
        System.out.println("You scored: " + marks);

        // Clear the newline character from previous input
        sc.nextLine();

        // Read a full line (multiple words)
        System.out.print("Enter your address: ");
        String address = sc.nextLine();
        System.out.println("Your address is: " + address);

        sc.close();
    }
}
