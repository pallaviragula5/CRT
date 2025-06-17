import java.util.Scanner;

public class BubbleSortWithSwapCount {

    // Method to perform bubble sort and count swaps
    public static int bubbleSort(int[] arr) {
        int n = arr.length;
        int swapCount = 0;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapCount++;
                    swapped = true;
                }
            }

            // Stop if no swaps happened (already sorted)
            if (!swapped) break;
        }

        return swapCount;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] array = new int[n];

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        int swaps = bubbleSort(array);

        System.out.println("Sorted array:");
        for (int val : array) {
            System.out.print(val + " ");
        }

        System.out.println("\nTotal number of swaps: " + swaps);

        sc.close();
    }
}
