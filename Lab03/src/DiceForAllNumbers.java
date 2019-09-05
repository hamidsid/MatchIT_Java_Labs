import java.util.Random;
import java.util.Scanner;

public class DiceForAllNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many times would you like to roll the dice?");
        int rolls = sc.nextInt();
        int[] myArr = new int[6]; //creates an array of user-specified length (rolls)


        System.out.println("Roll\t\tCount"); //Headers for the results table
        for (int i = 0; i < rolls; i++) {
            int dice = diceRoll();
            myArr[dice - 1] = myArr[dice - 1] + 1;
        }
        System.out.println(java.util.Arrays.toString(myArr));
    }

    public static int diceRoll() { //roll the dice which comes a number between 1 and 6
        Random rand = new Random();
        int dice = rand.nextInt(6) + 1;
        return dice;
    }

}