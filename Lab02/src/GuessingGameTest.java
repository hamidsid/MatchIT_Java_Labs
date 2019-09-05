import java.util.Random;
import java.util.Scanner;

public class GuessingGameTest {
    private static Random rand = new Random();
    private static Scanner input = new Scanner(System.in);
    private static boolean quit = false;
    private static boolean win = false;
    private static int target;
    private static int tries;
    private static int highNum = 0;

    public static void main(String[] args) {
        while (!quit) {
            playGame();
        }
    }

    private static void playGame() {

        System.out.println("Hello and welcome to my number guessing game.");
        System.out.println("Pick a highest possible number: ");
        highNum = input.nextInt();

        if (highNum > 100) {
            System.out.println("This is a big number, it might take you a while to guess.");
            System.out.println("Do you still want to continue?");
            System.out.println("Type 0 for yes, type 1 for no.");
            int choice = input.nextInt();
            if(choice == 0) {

                target = rand.nextInt(highNum);
                guess(target);
            } 
            else {
                System.out.println("Pick a different number: ");
                highNum = input.nextInt();
                target = rand.nextInt(highNum);
                guess(target);
            }
        } else {
            System.out.println("Okay. Pick a number between 0 and " + highNum);
            target = rand.nextInt(highNum);
            guess(target);
        }
    }

    private static void guess(int randNum) {
        int guess = 0;
        while(!win) {
            guess = input.nextInt();
            if (guess == randNum) {
                win = true;

            } else if (guess < randNum) {
                System.out.println("Number is to low, try again");

            } else if (guess > randNum) {
                System.out.println("Number is to high, try again");
            }
            tries++;
        }
        playAgainMessage(guess);
    }

    private static void playAgainMessage(int correctNum) {
        System.out.println("You win! The number was " + correctNum);
        System.out.println("You got it in " + tries + " tries!");
        System.out.println("Would you like to play again(y/n)?");
        String play = input.next();
        if (play.equalsIgnoreCase("y")) {
            System.out.println("The game will restart.");
            System.out.flush();
            win = false;
            playGame();
        } else {
            System.out.println("The game will quit.");
            quit = true;
        }
    }
}
