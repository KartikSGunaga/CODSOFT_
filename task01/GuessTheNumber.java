package task01;

import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Welcome to the number guessing game! ");
        int score = 0;
        boolean continueGame;

        do {
            // Generate a random number
            int randomNumber = randomGenerator();

            // Check if the user guessed the number
            boolean guessed = guessNumber(randomNumber);

            if (guessed) {
                // If guessed correctly, update the score and check if the user wants to continue
                System.out.println("You've got it right! I had " + randomNumber
                + " in mind!");
                score += 1;
                continueGame = isContinue(score);
            } else {
                // If guessed incorrectly, end the game
                System.out.println("You've ran out of chances. The number to be guessed was: " + randomNumber + ".");
                continueGame = false;
            }
        } while (continueGame);
    }

    // Method to ask the user if they want to continue playing
    public static boolean isContinue(int score) {
        System.out.println("You guessed it right!");
        System.out.println("Your score is: " + score);

        System.out.println("Press 'y' to continue the game: ");
        String proceed = scanner.next();

        // If the user wants to continue, return true; otherwise, return false
        return proceed.equals("y");
    }

    // Method for the user to guess a number
    public static boolean guessNumber(int randomNum) {
        System.out.println("Press 'h' to play hard level; other key for easy level");
        String level = scanner.next();

        int chances;

        // Set the number of chances based on the difficulty level
        if (level.equals("h")) {
            chances = 5;
        } else {
            chances = 10;
        }

        // Allow the user to guess until they run out of chances
        while (chances > 0) {
            System.out.println("You have " + chances + " chances remaining.");
            System.out.println("Take a guess: ");
            int guessNum = scanner.nextInt();

            if (guessNum == randomNum) {
                // If the guess is correct, return true
                return true;
            } else if (guessNum > randomNum) {
                System.out.println("Guess lower.");
                chances -= 1;
            } else {
                System.out.println("Guess higher.");
                chances -= 1;
            }
        }

        // If the user runs out of chances, return false
        return false;
    }

    // Method to generate a random number based on user input
    public static int randomGenerator() {
        System.out.println("Enter the range you want to guess in: ");
        int range = scanner.nextInt();

        // Generate a random number within the specified range
        int randomNum = random.nextInt(range) + 1;
        System.out.println("I have a number in mind.");
        return randomNum;
    }
}
