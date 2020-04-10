package fr.model.player;

import java.util.ArrayDeque;

public class DiscardStack {

    private ArrayDeque<Card> discardStack;


    DiscardStack() {
        discardStack = new ArrayDeque<>();
    }


    public void add(Card card) { discardStack.addFirst(card); }

    public ArrayDeque<Card> getDiscardStack() { return discardStack; }

    public void clear() { discardStack.clear(); }

}
