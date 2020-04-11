import fr.controller.Controller;
import fr.view.GUI;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();
        GUI gui = new GUI(controller);
    }
}
