// Functional Interface
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

public class  {
    public static void main(String[] args) {

        // Lambda expression with one parameter
        Greeting greet = (name) -> {
            System.out.println("Hello, " + name + "!");
        };

        // Invoking lambda with different inputs
        greet.sayHello("Alice");
        greet.sayHello("Bob");
        greet.sayHello("Charlie");
    }
}
