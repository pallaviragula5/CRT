import java.util.HashSet;
import java.util.Scanner;

public class HashSetExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashSet<Integer> integerSet = new HashSet<>();
        HashSet<String> stringSet = new HashSet<>();

        // Input integers
        System.out.print("How many integers do you want to add to the set? ");
        int intCount = sc.nextInt();
        System.out.println("Enter " + intCount + " integers:");
        for (int i = 0; i < intCount; i++) {
            int num = sc.nextInt();
            integerSet.add(num);
        }

        sc.nextLine(); // consume newline

        // Input strings
        System.out.print("How many strings do you want to add to the set? ");
        int strCount = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.println("Enter " + strCount + " strings:");
        for (int i = 0; i < strCount; i++) {
            String str = sc.nextLine();
            stringSet.add(str);
        }

        // Display both sets
        System.out.println("\n--- Integer Set ---");
        for (Integer i : integerSet) {
            System.out.println(i);
        }

        System.out.println("\n--- String Set ---");
        for (String s : stringSet) {
            System.out.println(s);
        }

        sc.close();
    }
}
