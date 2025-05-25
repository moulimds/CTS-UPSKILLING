import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StreamEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.print("How many numbers do you want to enter? ");
        int count = scanner.nextInt();

        // Input numbers
        for (int i = 0; i < count; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers.add(scanner.nextInt());
        }

        // Filter even numbers using Stream API
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n % 2 == 0)
                                           .collect(Collectors.toList());

        // Display result
        System.out.println("\nEven Numbers:");
        evenNumbers.forEach(System.out::println);

        scanner.close();
    }
}
