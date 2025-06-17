import java.util.Scanner;

public class CheckMinHeapProperty {

    // Method to check if array satisfies min-heap property
    public static boolean isMinHeap(int[] heap) {
        int n = heap.length;

        // Check for each parent node
        for (int i = 0; i <= (n - 2) / 2; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            // If left child exists and is smaller than parent
            if (left < n && heap[i] > heap[left]) {
                return false;
            }

            // If right child exists and is smaller than parent
            if (right < n && heap[i] > heap[right]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements in heap: ");
        int n = sc.nextInt();
        int[] heap = new int[n];

        System.out.println("Enter heap elements (level-order):");
        for (int i = 0; i < n; i++) {
            heap[i] = sc.nextInt();
        }

        if (isMinHeap(heap)) {
            System.out.println("The given array satisfies Min-Heap property.");
        } else {
            System.out.println("The given array does NOT satisfy Min-Heap property.");
        }

        sc.close();
    }
}
