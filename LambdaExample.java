// Functional Interface
@FunctionalInterface
interface MyOperation {
    int operate(int a, int b); // Single abstract method
}

public class LambdaExample {
    public static void main(String[] args) {

        // Lambda expression for addition
        MyOperation add = (a, b) -> a + b;

        // Lambda expression for multiplication
        MyOperation multiply = (a, b) -> a * b;

        // Lambda expression for subtraction
        MyOperation subtract = (a, b) -> a - b;

        // Using the lambda expressions
        System.out.println("Addition: " + add.operate(10, 5));
        System.out.println("Multiplication: " + multiply.operate(10, 5));
        System.out.println("Subtraction: " + subtract.operate(10, 5));
    }
}
