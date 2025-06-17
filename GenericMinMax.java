import java.util.*;

public class GenericMinMax {

    // Generic method to find minimum
    public static <T extends Comparable<T>> T findMin(List<T> list) {
        return Collections.min(list);
    }

    // Generic method to find maximum
    public static <T extends Comparable<T>> T findMax(List<T> list) {
        return Collections.max(list);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        if (!numbers.isEmpty()) {
            Integer min = findMin(numbers);
            Integer max = findMax(numbers);

            System.out.println("Minimum number: " + min);
            System.out.println("Maximum number: " + max);
        } else {
            System.out.println("List is empty.");
        }

        scanner.close();
    }
}
