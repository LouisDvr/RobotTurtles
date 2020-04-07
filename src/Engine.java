import fr.board.Board;
import fr.graphs.Node;
import fr.player.Card;
import fr.player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Engine {

    public static Board board;
    private static int nbOfPlayers;
    private ArrayList<Player> listOfPlayers = new ArrayList<>();

    public void initGame(int nbOfPlayers) {
        //creates the objects that will be used in the game

        Engine.nbOfPlayers = nbOfPlayers;
        board = new Board(nbOfPlayers);
        for (int i=0; i<nbOfPlayers; ++i) {
            listOfPlayers.add(new Player());
        }
    }

    private void refillHand(Player player) { player.refillHand(); }

    private void discard(Player player, Card card) { player.discard(card); }


}
