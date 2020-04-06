import fr.player.Player;

public class Test {

    public static void main(String[] args) {
        Player player = new Player();
        System.out.println(player.getDirection());
        player.turnLeft();
        System.out.println(player.getDirection());
        player.turnLeft();
        System.out.println(player.getDirection());
        player.turnLeft();
        System.out.println(player.getDirection());
    }
}
