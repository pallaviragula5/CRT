import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        // Create a priority queue of integers (min-heap by default)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Priority Queue Menu ---");
            System.out.println("1. Add element");
            System.out.println("2. Peek (View top priority)");
            System.out.println("3. Remove top priority");
            System.out.println("4. Display Queue");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to add: ");
                    int element = sc.nextInt();
                    pq.add(element);
                    System.out.println("Added: " + element);
                    break;

                case 2:
                    if (!pq.isEmpty())
                        System.out.println("Top Priority Element: " + pq.peek());
                    else
                        System.out.println("Queue is empty.");
                    break;

                case 3:
                    if (!pq.isEmpty()) {
                        int removed = pq.poll();
                        System.out.println("Removed: " + removed);
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;

                case 4:
                    System.out.println("Priority Queue Elements: " + pq);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
