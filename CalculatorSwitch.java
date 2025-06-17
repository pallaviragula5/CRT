import java.util.Scanner;

public class CalculatorSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter operator (+ - * /): ");
        char op = sc.next().charAt(0);
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        switch (op) {
            case '+' -> System.out.println("Result: " + (num1 + num2));
            case '-' -> System.out.println("Result: " + (num1 - num2));
            case '*' -> System.out.println("Result: " + (num1 * num2));
            case '/' -> {
                if (num2 != 0)
                    System.out.println("Result: " + (num1 / num2));
                else
                    System.out.println("Cannot divide by zero.");
            }
            default -> System.out.println("Invalid operator.");
        }

        sc.close();
    }
}
