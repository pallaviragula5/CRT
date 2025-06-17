import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private double salary;

    // Constructor
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Display employee details
    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name + ", Salary: ₹" + salary;
    }
}

public class EmployeeHashMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Employee> employeeMap = new HashMap<>();

        System.out.print("How many employees do you want to add? ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter Employee ID (integer): ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline

            if (employeeMap.containsKey(id)) {
                System.out.println("Employee ID already exists. Skipping...");
                continue;
            }

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Employee Salary: ");
            double salary = sc.nextDouble();

            // Create and store employee
            Employee emp = new Employee(id, name, salary);
            employeeMap.put(id, emp);
        }

        // Display all employees
        System.out.println("\n--- Employee Details ---");
        for (Map.Entry<Integer, Employee> entry : employeeMap.entrySet()) {
            System.out.println(entry.getValue());
        }

        sc.close();
    }
}
