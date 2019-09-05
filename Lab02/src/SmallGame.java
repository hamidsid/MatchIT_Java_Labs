import java.util.Random;
import java.util.Scanner;

public class SmallGame {

    public static void main(String[] args) {


        int max = 20;
        int min = 1;
        Random random = new Random();

        //generate random integer number between 1 and 20
        int secretNumber = min + random.nextInt(max);
        int numberOfTries = 0;
        Scanner scanner = new Scanner(System.in);
        int guessNumber;
        boolean gameOver = false;

        //keep the track of time when the game starts
        long start = System.currentTimeMillis();


        //continue the game until the user wins
        while (!gameOver) {

            System.out.println("Please guess a number between 1 and 20!");
            guessNumber = scanner.nextInt();
            numberOfTries++;

            if (guessNumber > secretNumber) {
                System.out.println("The number that you have guessed is bigger!");
            } else if (guessNumber < secretNumber) {
                System.out.println("The number that you have guessed is smaller!");
            } else {
                System.out.println("Congratulations you guessed it right!");
                gameOver = true;
            }
        }

        //kee the track of time when the game is finished
        long end = System.currentTimeMillis();

        //find the time spent on game in seconds
        long spentTime = ((end - start) / 1000);

        System.out.println("The number that you were suppose to guess was = " + secretNumber);
        System.out.println("It took you  " + numberOfTries + " number of guesses to find the correct number!");
        System.out.println("Time that you had spent to guess the correct number was " + spentTime + " seconds");


    }


}
