package fr.player;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayDeque<Card> deck;


    Deck() {
        deck = new ArrayDeque<>();
        initDeck();
    }


    private void initDeck() {
        //initialise the deck by putting the right number of cards and shuffling them

        ArrayList<Card> cardsList = new ArrayList<>();
        for (Card card : Card.values()) {
            for (int i = 0; i < card.getNumber(); ++i) {
                cardsList.add(card);
            }
        }
        Collections.shuffle(cardsList);

        while (!cardsList.isEmpty()) {
            deck.addLast(cardsList.remove(0));
        }
    }

    public Card drawCard() { return deck.pollFirst(); }

    public void shuffle() {
        ArrayList<Card> cardsList = new ArrayList<>();
        while (!deck.isEmpty()) {
            cardsList.add(deck.pollFirst());
        }
        Collections.shuffle(cardsList);
        while (!cardsList.isEmpty()) {
            deck.addLast(cardsList.remove(0));
        }
    }

    public boolean isEmpty() { return deck.isEmpty(); }

    public void add(Card card) { deck.addLast(card); }

}
