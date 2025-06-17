import java.util.Scanner;

public class OptimizedBubbleSort {

    // Optimized Bubble Sort method
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Outer loop for each pass
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop for comparisons in unsorted part
            for (int j = 0; j < n - 1 - i; j++) {
                // Swap if elements are in wrong order
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no elements were swapped in inner loop, array is sorted
            if (!swapped) {
                break;
            }
        }
    }

    // Main method to take user input and sort
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        bubbleSort(array);

        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
