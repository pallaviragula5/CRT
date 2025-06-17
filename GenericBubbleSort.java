import java.util.Scanner;

public class GenericBubbleSort {

    // Generic Bubble Sort method
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        boolean swapped;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // Swap
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose input type: 1. Integer  2. String");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        if (choice == 1) {
            Integer[] arr = new Integer[n];
            System.out.println("Enter " + n + " integers:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            bubbleSort(arr);
            System.out.println("Sorted integers:");
            for (Integer val : arr) {
                System.out.print(val + " ");
            }
        } else if (choice == 2) {
            String[] arr = new String[n];
            System.out.println("Enter " + n + " strings:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLine();
            }
            bubbleSort(arr);
            System.out.println("Sorted strings:");
            for (String val : arr) {
                System.out.print(val + " ");
            }
        } else {
            System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
