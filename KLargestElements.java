import java.util.PriorityQueue;
import java.util.Scanner;

public class KLargestElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size and elements
        System.out.print("Enter the number of elements in array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input value of k
        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        // Min Heap to store k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove smallest among the k+1 to keep only k
            }
        }

        // Output k largest elements (not necessarily sorted)
        System.out.println("\nK largest elements are:");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }

        sc.close();
    }
}
