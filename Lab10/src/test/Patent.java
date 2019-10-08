package test;

import cards.Card;
import cards.Deck;

public class Patent {
    public static void main(String[] args) {
        Deck deck;
        Card card;
        int wins = 0;
        boolean goOut;
        int checkValue = 1;
        final int GAMES = 1000000;

        long start = System.currentTimeMillis();

        for (int i = 0; i < GAMES; i++) {
            deck = new Deck();
            deck.shuffle();
            goOut = true;

            while (deck.moreCards() && goOut) {
                card = deck.getCard();

                //if the card is not the same as value of ace (rank is not 1)
                if (card.getRank() != checkValue) {
                    goOut = true;
                } else {
                    goOut = false;
                }

                //increment the value until 3
                checkValue++;
                if (checkValue > 3) {

                    //if its bigger than 3 then reset it to 1
                    checkValue = 1;
                }
            }

            //count number of go outs
            if (goOut) {
                wins++;
            }
        }

        System.out.println(((double)System.currentTimeMillis() - start) / 1000);
        System.out.println(((double) wins / GAMES) + " probability!");
    }
}