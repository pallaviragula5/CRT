import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaxHeapUsingPriorityQueue {
    public static void main(String[] args) {
        // Create a Max Heap (by reversing natural order using Comparator)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements to insert: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            maxHeap.add(num);
        }

        System.out.println("\nMax Heap internal structure (unsorted):");
        System.out.println(maxHeap);

        System.out.println("\nRemoving elements in descending order:");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }

        sc.close();
    }
}
