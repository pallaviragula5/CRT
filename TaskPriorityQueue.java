import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

class Task {
    String name;
    int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + "}";
    }
}

public class TaskPriorityQueue {
    public static void main(String[] args) {
        // Min-Heap: lower priority number means higher priority
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(new Comparator<Task>() {
            public int compare(Task t1, Task t2) {
                return Integer.compare(t1.priority, t2.priority); // ascending order
            }
        });

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of tasks: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter task name: ");
            String name = scanner.nextLine();

            System.out.print("Enter priority (lower number = higher priority): ");
            int priority = scanner.nextInt();
            scanner.nextLine(); // consume newline

            taskQueue.add(new Task(name, priority));
        }

        System.out.println("\nTasks sorted by priority:");
        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }

        scanner.close();
    }
}
