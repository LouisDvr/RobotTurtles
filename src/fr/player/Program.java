package fr.player;

import java.util.ArrayDeque;

public class Program {

    private ArrayDeque<Card> program;


    Program() {
        program = new ArrayDeque<>();
    }


    public void addCard(Card card) {
        program.addLast(card);
    }

    public Card getInstruction() {
        return program.pollFirst();
    }

    public boolean isEmpty() { return program.isEmpty(); }
}
