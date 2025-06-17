import java.util.Scanner;

public class GenericSwap {

    // Generic method to swap elements in an array
    public static <T> void swap(T[] array, int index1, int index2) {
        if (array == null || index1 < 0 || index2 < 0 ||
            index1 >= array.length || index2 >= array.length) {
            throw new IllegalArgumentException("Invalid indices or array is null.");
        }

        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    // Generic method to print array
    public static <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for type
        System.out.println("Choose data type (int/string):");
        String type = scanner.nextLine().toLowerCase();

        // Ask for size
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (type.equals("int")) {
            Integer[] intArray = new Integer[n];
            System.out.println("Enter " + n + " integer values:");
            for (int i = 0; i < n; i++) {
                intArray[i] = scanner.nextInt();
            }

            System.out.print("Enter indices to swap (0-based): ");
            int i1 = scanner.nextInt();
            int i2 = scanner.nextInt();

            System.out.println("Before swap:");
            printArray(intArray);

            swap(intArray, i1, i2);

            System.out.println("After swap:");
            printArray(intArray);

        } else if (type.equals("string")) {
            String[] strArray = new String[n];
            System.out.println("Enter " + n + " strings:");
            for (int i = 0; i < n; i++) {
                strArray[i] = scanner.nextLine();
            }

            System.out.print("Enter indices to swap (0-based): ");
            int i1 = scanner.nextInt();
            int i2 = scanner.nextInt();

            System.out.println("Before swap:");
            printArray(strArray);

            swap(strArray, i1, i2);

            System.out.println("After swap:");
            printArray(strArray);

        } else {
            System.out.println("Unsupported type. Only 'int' and 'string' are allowed.");
        }

        scanner.close();
    }
}
