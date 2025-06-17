import java.util.PriorityQueue;
import java.util.Scanner;

public class MinHeapSortedOutput {
    public static void main(String[] args) {
        // MinHeap using PriorityQueue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements to insert: ");
        int n = scanner.nextInt();

        // Inserting n elements into the heap
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            minHeap.add(value);
        }

        // Removing and printing elements in ascending order
        System.out.println("\nElements in sorted order:");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }

        scanner.close();
    }
}
