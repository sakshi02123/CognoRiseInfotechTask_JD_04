import java.util.Scanner;
import java.util.Random;

public class HangmanGame {
    private static final String[] WORDS = {"java", "python", "programming", "computer", "algorithm", "software"};

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String wordToGuess = WORDS[random.nextInt(WORDS.length)];
        int wordLength = wordToGuess.length();

        char[] display = new char[wordLength];
        for (int i = 0; i < wordLength; i++) {
            display[i] = '_';
        }

        int maxAttempts = 6;
        int attemptsLeft = maxAttempts;
        boolean wordGuessed = false;

        System.out.println("Welcome to Hangman Game!");

        while (attemptsLeft > 0 && !wordGuessed) {
            System.out.println("\nWord to guess:");
            displayWord(display);

            System.out.println("\nAttempts left: " + attemptsLeft);
            System.out.print("Enter a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            boolean letterFound = false;
            for (int i = 0; i < wordLength; i++) {
                if (wordToGuess.charAt(i) == guess) {
                    display[i] = guess;
                    letterFound = true;
                }
            }

            if (!letterFound) {
                attemptsLeft--;
                System.out.println("Incorrect guess!");
                displayHangman(maxAttempts - attemptsLeft);
            }

            if (String.valueOf(display).equals(wordToGuess)) {
                wordGuessed = true;
            }
        }

        if (wordGuessed) {
            System.out.println("\nCongratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("\nGame over! The word was: " + wordToGuess);
        }

        scanner.close();
    }

    private static void displayWord(char[] display) {
        for (char ch : display) {
            System.out.print(ch + " ");
        }
    }

    private static void displayHangman(int incorrectAttempts) {
        switch (incorrectAttempts) {
            case 1:
                System.out.println("  ___");
                System.out.println(" |   |");
                System.out.println(" |   O");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("|");
                break;
            case 2:
                System.out.println("  ___");
                System.out.println(" |   |");
                System.out.println(" |   O");
                System.out.println(" |   |");
                System.out.println(" |");
                System.out.println("|");
                break;
            case 3:
                System.out.println("  ___");
                System.out.println(" |   |");
                System.out.println(" |   O");
                System.out.println(" |  /|");
                System.out.println(" |");
                System.out.println("|");
                break;
            case 4:
                System.out.println("  ___");
                System.out.println(" |   |");
                System.out.println(" |   O");
                System.out.println(" |  /|\\");
                System.out.println(" |");
                System.out.println("|");
                break;
            case 5:
                System.out.println("  ___");
                System.out.println(" |   |");
                System.out.println(" |   O");
                System.out.println(" |  /|\\");
                System.out.println(" |  /");
                System.out.println("|");
                break;
            case 6:
                System.out.println("  ___");
                System.out.println(" |   |");
                System.out.println(" |   O");
                System.out.println(" |  /|\\");
                System.out.println(" |  / \\");
                System.out.println("|");
                break;
        }
    }
}