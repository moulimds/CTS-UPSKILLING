import java.util.Scanner;
public class PalindromeChecker {    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a string: ");
        String original = sc.nextLine();

        // Check if the string is a palindrome
        String reversed = new StringBuilder(original).reverse().toString();
        boolean isPalindrome = original.equalsIgnoreCase(reversed);

        // Display result
        if (isPalindrome) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }

        sc.close();
    }

    
}
