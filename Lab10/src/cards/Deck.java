package cards;

import java.util.ArrayList;
import java.util.Collections;
public class Deck {

    private ArrayList<Card> cardList;
    private int current;

    /**
     * Skapar en blandad kortlek med 52 kort.
     * Creates a deck of 52 cards in order.
     */
    public Deck() {

        cardList = new ArrayList<>();

        for(int suit = Card.CLUBS; suit <= Card.SPADES; suit++){
            for (int rank = 1; rank <= 13; rank++){
                cardList.add(new Card(suit,rank));
            }
        }
    }


    /**
     Shuffles the cards inside the deck
     */
    public void shuffle(){
        Collections.shuffle(cardList);
    }


    /**
     * Drar det översta kortet i kortleken.
     *
     * Return the next card in the deck (will throw
     * an exception if there are no more cards).
     * @return the next ICard in this deck.
     */


    public Card getCard() {
        return cardList.remove(0);
    }

    /**
     * Undersöker om det finns fler kort i kortleken.
     * @return true if there are more cards in the deck.
     */
    public boolean moreCards() {
        return 0 < cardList.size();

    }
}
