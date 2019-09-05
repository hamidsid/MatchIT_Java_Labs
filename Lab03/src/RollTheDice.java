import java.util.Random;
import java.util.Scanner;

public class RollTheDice {

    public static void main(String[] args) {
        Random random = new Random() ;
        Scanner scanner = new Scanner(System.in);
        int sixes = 0;


        System.out.println("How many times do you want to roll the dice? ");
        int diceNumber = scanner.nextInt();



        for (int i = 0; i <= diceNumber; i++) {
            int numberSix = diceRoll();
            System.out.println(numberSix);
            if (numberSix == 6) {
                System.out.println("A 6 has been rolled!");
                sixes++;
            }
        }

        System.out.println("#################################################");
        System.out.println("A 6 has been rolled " + sixes + " times!");
        System.out.println("The proportion of 6's : " + ((double)sixes / diceNumber));
    }

    public static int diceRoll(){ //roll the dice which comes a number between 1 and 6
        Random rand = new Random();
        int dice = rand.nextInt(6)+1;
        return dice;
    }


}
