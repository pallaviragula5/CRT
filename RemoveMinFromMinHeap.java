import java.util.PriorityQueue;
import java.util.Scanner;

public class RemoveMinFromMinHeap {
    public static void main(String[] args) {
        // Create a MinHeap using PriorityQueue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements to insert: ");
        int n = scanner.nextInt();

        // Insert elements into the minHeap
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            int value = scanner.nextInt();
            minHeap.add(value);
        }

        // Repeatedly remove and print the minimum element
        System.out.println("\nRemoving elements in ascending order:");
        while (!minHeap.isEmpty()) {
            int min = minHeap.poll(); // Removes and returns the smallest element
            System.out.print(min + " ");
        }

        scanner.close();
    }
}
