import java.util.Scanner;

public class PatternMatchingSwitch {

    public static Object parseInput(String input) {
        // Try to parse input as Integer
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ignored) {}

        // Try to parse input as Double
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException ignored) {}

        // Try to parse input as Boolean
        if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
            return Boolean.parseBoolean(input);
        }

        // Fallback: treat as String
        return input;
    }

    public static void checkObjectType(Object obj) {
        switch (obj) {
            case Integer i -> System.out.println("This is an Integer: " + i);
            case Double d -> System.out.println("This is a Double: " + d);
            case Boolean b -> System.out.println("This is a Boolean: " + b);
            case String s -> System.out.println("This is a String: " + s);
            case null -> System.out.println("This is null.");
            default -> System.out.println("Unknown type: " + obj);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter something: ");
        String userInput = scanner.nextLine();

        Object parsedInput = parseInput(userInput);

        checkObjectType(parsedInput);

        scanner.close();
    }
}
