package test;

import cards.Card;
import cards.Deck;
public class PatentV2 {
	public static void main(String[] args) {
		final int GAMES = 100000;
		int wins = 0;
		
		for (int i = 0; i < GAMES; i++) {
			if (!play()) {
				wins++;
			}
		}
		System.out.println("Probability =  " + (double) wins / GAMES);
	}
	
	public static boolean play() {
		Deck deck = new Deck();
		deck.shuffle();
		int count = 0;

		//at first we are inside the play and it has not gone out
		boolean goOut = false;

		//continue the loop until there are cards in the deck and we are inside the play
		while (deck.moreCards() && !goOut) {
			Card c = deck.getCard();

			//if the card is not the same as value of ace (rank is not 1)
			if (c.getRank() == count + 1) {
				goOut = true;
			}

			//increment the value until 3
			count = (count + 1) % 3;
		}
		return goOut; // true om spelet är förlorat, false om patiensen gick ut
	}
}