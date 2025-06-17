import java.util.PriorityQueue;
import java.util.Scanner;

public class MinHeapExample {
    public static void main(String[] args) {
        // Create a MinHeap using PriorityQueue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements to insert: ");
        int n = scanner.nextInt();

        // Insert elements into the minHeap
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            int value = scanner.nextInt();
            minHeap.add(value);
        }

        // Print the minHeap (heap structure is not fully sorted)
        System.out.println("\nMinHeap elements (internal structure):");
        System.out.println(minHeap);

        // Display elements in ascending order by polling
        System.out.println("\nMinHeap elements in sorted order (removal):");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }

        scanner.close();
    }
}
