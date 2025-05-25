import java.util.Scanner;
public class DataType {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt and read int value
        System.out.print("Enter an integer value: ");
        int myInt = scanner.nextInt();

        // Prompt and read float value
        System.out.print("Enter a float value: ");
        float myFloat = scanner.nextFloat();

        // Prompt and read double value
        System.out.print("Enter a double value: ");
        double myDouble = scanner.nextDouble();

        // Consume newline left-over
        scanner.nextLine();

        // Prompt and read char value
        System.out.print("Enter a single character: ");
        char myChar = scanner.nextLine().charAt(0);

        // Prompt and read boolean value
        System.out.print("Enter a boolean value (true/false): ");
        boolean myBoolean = scanner.nextBoolean();

        // Display the values
        System.out.println("\nYou entered:");
        System.out.println("Integer value: " + myInt);
        System.out.println("Float value: " + myFloat);
        System.out.println("Double value: " + myDouble);
        System.out.println("Character value: " + myChar);
        System.out.println("Boolean value: " + myBoolean);

        scanner.close();
    }
}


