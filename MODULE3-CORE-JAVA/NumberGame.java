import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int numberToGuess = rand.nextInt(100) + 1; // 1 to 100
        int guess;
        
        System.out.println("Guess the number (between 1 and 100):");

        while (true) {
            System.out.print("Your guess: ");
            guess = sc.nextInt();

            if (guess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Correct! You guessed the number.");
                break;
            }
        }

        sc.close();
    }
}
