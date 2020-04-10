package fr.model.player;

import java.util.ArrayList;
import java.util.Comparator;

public class Hand {

    static final int MAX_LENGTH = 5;

    private ArrayList<Card> hand;


    Hand() {
        hand = new ArrayList<>();
    }


    public ArrayList<String> viewHand() {
        ArrayList<String> handView = new ArrayList<>();
        for (Card card : hand) {
            handView.add(card.toString());
        }
        return handView;
    }

    public void add(Card card) { hand.add(card); }

    public Card playCard(Card card) {
        switch (card) {
            case FORWARD:
                hand.remove(Card.FORWARD);
                return Card.FORWARD;
            case LEFT:
                hand.remove(Card.LEFT);
                return Card.LEFT;
            case RIGHT:
                hand.remove(Card.RIGHT);
                return Card.RIGHT;
            case LASER:
                hand.remove(Card.LASER);
                return Card.LASER;
            default:
                return null;
        }
    }

    public void sort() { hand.sort(Comparator.naturalOrder()); }

    public int size() { return hand.size(); }

    public boolean isEmpty() { return hand.isEmpty(); }
}
