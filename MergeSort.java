import java.util.Scanner;

public class MergeSort {

    // Merge two sorted subarrays: arr[left..mid] and arr[mid+1..right]
    public static void merge(int[] arr, int left, int mid, int right) {
        // Sizes of two subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temp arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            leftArray[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            rightArray[j] = arr[mid + 1 + j];

        // Merge the temp arrays
        int i = 0, j = 0;
        int k = left;  // Initial index of merged subarray

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        // Copy remaining elements of leftArray[]
        while (i < n1) {
            arr[k++] = leftArray[i++];
        }

        // Copy remaining elements of rightArray[]
        while (j < n2) {
            arr[k++] = rightArray[j++];
        }
    }

    // Recursive merge sort function
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = left + (right - left) / 2;

            // Recursively sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
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

        mergeSort(array, 0, n - 1);

        System.out.println("Sorted array using Merge Sort:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
