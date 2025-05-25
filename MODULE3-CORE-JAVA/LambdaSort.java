import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LambdaSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = new ArrayList<>();

        System.out.print("How many names do you want to enter? ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Read user input
        for (int i = 0; i < count; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names.add(scanner.nextLine());
        }

        // Sort using lambda expression
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));

        // Display sorted list
        System.out.println("\nSorted List of Names:");
        for (String name : names) {
            System.out.println(name);
        }

        scanner.close();
    }
}
