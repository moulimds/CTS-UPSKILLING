import java.util.Scanner;

public class StringReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a string: ");
        String original = sc.nextLine();

        // Reversal using StringBuilder
        String reversed = new StringBuilder(original).reverse().toString();

        // Display result
        System.out.println("Reversed string: " + reversed);

        sc.close();
    }
}
