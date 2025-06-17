import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int original = sc.nextInt(), num = original;
        int reverse = 0;
        while (num != 0) {
            reverse = reverse * 10 + num % 10;
            num /= 10;
        }
        System.out.println(original == reverse ? "Palindrome" : "Not Palindrome");
        sc.close();
    }
}
