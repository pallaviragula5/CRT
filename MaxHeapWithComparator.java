import java.util.*;

public class MaxHeapWithComparator {
    public static void main(String[] args) {
        // Create a Max Heap using a custom comparator (descending order)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements to insert: ");
        int n = scanner.nextInt();

        // Insert elements
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            maxHeap.add(value);
        }

        // Display the heap
        System.out.println("\nHeap structure (not sorted): " + maxHeap);

        // Print elements in descending order (max to min)
        System.out.println("\nRemoving elements in descending order:");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }

        scanner.close();
    }
}
