package fr.controller;

import fr.model.board.Board;
import fr.model.player.Card;
import fr.model.player.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class Controller {

    public static Board board;
    private static int nbOfPlayers;
    private ArrayList<Player> listOfPlayers = new ArrayList<>();
    private Player currentPlayer;


    public Controller() {

    }

    public void initGame(int nbOfPlayers) {
        //creates the objects that will be used in the game

        Controller.nbOfPlayers = nbOfPlayers;
        board = new Board(nbOfPlayers);
        for (int i=0; i<nbOfPlayers; ++i) {
            listOfPlayers.add(new Player());
        }
        currentPlayer = listOfPlayers.get(0);
    }

    private void refillHand(Player player) { player.refillHand(); }

    private void discard(Player player, Card card) { player.discard(card); }

    public ArrayList<String> getPlayersDirections() {
        ArrayList<String> directions = new ArrayList<>();
        for (Player player : listOfPlayers) {
            directions.add(player.getDirection().toString()); // the players are always in ascending order so the first direction will be player1's direction and so on
        }
        return directions;
    }

    public HashMap<Integer, String> getBoard() {
        return board.getSquaresMap();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

}
