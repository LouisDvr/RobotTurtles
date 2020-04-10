package fr.model.player;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Player {

    private static int numberOfPlayers = 0;

    private String name;

    private int position;

    private Direction direction = Direction.SOUTH;

    private Deck deck = new Deck();

    private DiscardStack discardStack = new DiscardStack();

    private Hand hand = new Hand();

    private Program program = new Program();

    private int nbIceWall = 2;

    private int nbStoneWall = 3;


    public Player() {
        ++numberOfPlayers;
        name = "Player " + numberOfPlayers;
        refillHand();
    }


    public String getName() {
        return name;
    }

    public int getPosition() { return position; }

    public void updatePosition(int  position) {
        this.position = position;
    }

    public Direction getDirection() { return direction; }

    public void turnLeft() { direction = Direction.values()[(direction.ordinal() +3) %4]; }

    public void turnRight() { direction = Direction.values()[(direction.ordinal() +1) %4]; }

    public void addToProgram(Card card) {
        //takes a card from the player's hand and puts it at the end of the program
        program.addCard(hand.playCard(card));
    }

    public ArrayDeque<Card> executeProgram() {
        //returns the instructions included in the program
        //draw the first card of the program, keeps it value and puts it in the discardStack

        ArrayDeque<Card> instructions = new ArrayDeque<>();
        while (!program.isEmpty()) {
            Card card = program.getInstruction();
            instructions.addLast(card);
            discardStack.add(card);
        }
        return instructions;
    }

    public ArrayList<String> viewHand() { return hand.viewHand(); }

    public boolean isHandEmpty() { return hand.isEmpty(); }

    public void refillHand() {
        //refills the hand by drawing cards from the deck and sorts it

        while (hand.size() < Hand.MAX_LENGTH) {
            if (deck.isEmpty()) { refillDeck(); } //the deck must not be empty in order to draw a card
            hand.add(deck.drawCard());
        }
        hand.sort();
    }

    private void refillDeck() {
        //refills the deck by taking the cards in the discard stack

        ArrayDeque<Card> exDiscardStack = discardStack.getDiscardStack();
        discardStack.clear();
        while (!exDiscardStack.isEmpty()) {
            deck.add(exDiscardStack.pollFirst());
        }
        deck.shuffle();
    }

    public void discard(Card card) { discardStack.add(hand.playCard(card)); }

    public void useIceWall() { --nbIceWall; }

    public boolean hasIceWall() { return nbIceWall >= 0; }

    public void useStoneWall() { --nbStoneWall; }

    public boolean hasStoneWall() { return nbStoneWall >= 0; }

}
