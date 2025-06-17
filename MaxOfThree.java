import java.util.Scanner;

public class MaxOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        int max = Math.max(a, Math.max(b, c));
        System.out.println("Maximum: " + max);
        sc.close();
    }
}
