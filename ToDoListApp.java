import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {

    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        System.out.println("=== Welcome to the To-Do List App ===");

        do {
            printMenu();
            choice = getIntInput("Choose an option: ");

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    removeTask();
                    break;
                case 4:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1-4.");
            }

        } while (choice != 4);
    }

    private static void printMenu() {
        System.out.println("\n------ MENU ------");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Remove Task");
        System.out.println("4. Exit");
    }

    private static void addTask() {
        System.out.print("Enter task name: ");
        String task = scanner.nextLine().trim();
        if (!task.isEmpty()) {
            tasks.add(task);
            System.out.println("Task added.");
        } else {
            System.out.println("Task cannot be empty.");
        }
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("Your Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void removeTask() {
        if (tasks.isEmpty()) {
            System.out.println("Task list is empty. Nothing to remove.");
            return;
        }

        System.out.println("Remove by: ");
        System.out.println("1. Task Number");
        System.out.println("2. Task Name");
        int option = getIntInput("Choose an option: ");

        if (option == 1) {
            int index = getIntInput("Enter task number to remove: ") - 1;
            if (index >= 0 && index < tasks.size()) {
                System.out.println("Removed: " + tasks.remove(index));
            } else {
                System.out.println("Invalid task number.");
            }
        } else if (option == 2) {
            System.out.print("Enter task name to remove: ");
            String name = scanner.nextLine().trim();
            if (tasks.remove(name)) {
                System.out.println("Removed task: " + name);
            } else {
                System.out.println("Task not found.");
            }
        } else {
            System.out.println("Invalid option.");
        }
    }

    private static int getIntInput(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // clear newline character
        return input;
    }
}
