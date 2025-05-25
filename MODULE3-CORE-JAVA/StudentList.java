import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> studentNames = new ArrayList<>();

        System.out.print("How many student names do you want to enter? ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        // Input names
        for (int i = 0; i < count; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            studentNames.add(name);
        }

        // Display all names
        System.out.println("\nList of Student Names:");
        for (String name : studentNames) {
            System.out.println(name);
        }

        scanner.close();
    }
}
