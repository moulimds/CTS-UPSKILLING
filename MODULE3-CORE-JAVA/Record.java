import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Record {

    
    public record Person(String name, int age) {}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        System.out.print("How many people do you want to enter? ");
        int count = scanner.nextInt();
        scanner.nextLine();

        
        for (int i = 0; i < count; i++) {
            System.out.print("Enter name of person " + (i + 1) + ": ");
            String name = scanner.nextLine();

            System.out.print("Enter age of " + name + ": ");
            int age = scanner.nextInt();
            scanner.nextLine(); 

            people.add(new Person(name, age));
        }

       
        System.out.println("\nAll People:");
        people.forEach(System.out::println);

        // Filter adults (age >= 18) using Stream API
        List<Person> adults = people.stream()
                                    .filter(person -> person.age() >= 18)
                                    .collect(Collectors.toList());

        // Display adults
        System.out.println("\nAdults (age >= 18):");
        adults.forEach(System.out::println);

        scanner.close();
    }
}
