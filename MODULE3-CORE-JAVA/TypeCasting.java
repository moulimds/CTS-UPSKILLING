 import java.util.Scanner;
public class TypeCasting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter a double value
        System.out.print("Enter a double value (with decimal): ");
        double myDouble = scanner.nextDouble();

        // Cast double to int (explicit casting)
        int myInt = (int) myDouble;

        // Prompt user to enter an int value
        System.out.print("Enter an integer value: ");
        int anotherInt = scanner.nextInt();

        // Cast int to double (implicit casting)
        double anotherDouble = anotherInt;

        // Display the results
        System.out.println("\nDouble value entered: " + myDouble);
        System.out.println("After casting double to int: " + myInt);
        System.out.println("Int value entered: " + anotherInt);
        System.out.println("After casting int to double: " + anotherDouble);

        scanner.close();
    }
}
