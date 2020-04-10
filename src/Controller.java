import fr.board.Board;
import fr.player.Card;
import fr.player.Player;

import java.util.ArrayList;

public class Controller {

    public static Board board;
    private static int nbOfPlayers;
    private ArrayList<Player> listOfPlayers = new ArrayList<>();


    public Controller(int nbOfPlayers) {
        initGame(nbOfPlayers);
    }

    public void initGame(int nbOfPlayers) {
        //creates the objects that will be used in the game

        Controller.nbOfPlayers = nbOfPlayers;
        board = new Board(nbOfPlayers);
        for (int i=0; i<nbOfPlayers; ++i) {
            listOfPlayers.add(new Player());
        }
    }

    private void refillHand(Player player) { player.refillHand(); }

    private void discard(Player player, Card card) { player.discard(card); }

    public String getPlayerDirection(String name) {
        for (Player player : listOfPlayers) {
            if (player.getName().equals(name)) {
                return player.getDirection().toString();
            }
        }
        return "South";
    }
}
