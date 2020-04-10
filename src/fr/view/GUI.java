package fr.view;

import fr.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class GUI {

    private JFrame frame = new JFrame();
    private TransitionPanel transitionPanel = new TransitionPanel();
    private JPanel gamePanel = new JPanel();
    private BoardPanel boardPanel = new BoardPanel();

    private Controller controller;


    public GUI(Controller controller) {
        this.controller = controller;
        configFrame();
        setTransitionPanel(1);
        frame.setContentPane(transitionPanel.getPanel());
        frame.setVisible(true);
    }


    private void configFrame() {
        frame.setTitle("Robot Turtles");
        frame.setSize(1028, 680);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    private void setTransitionPanel(int playerNumber) {
        switch (playerNumber) {
            case 1:
                transitionPanel.setColor(Color.BLUE);
                transitionPanel.setText("C'est au tour du joueur 1");
                break;
            case 2:
                transitionPanel.setColor(Color.RED);
                transitionPanel.setText("C'est au tour du joueur 2");
                break;
            case 3:
                transitionPanel.setColor(Color.MAGENTA);
                transitionPanel.setText("C'est au tour du joueur 3");
                break;
            case 4:
                transitionPanel.setColor(Color.GREEN);
                transitionPanel.setText("C'est au tour du joueur 4");
                break;
            default:
                break;
        }
    }

    private void configGamePanel() {
        gamePanel.setLayout(new BorderLayout());
        gamePanel.add(boardPanel.getPanel(), BorderLayout.CENTER);
    }

    private void updateBoard() {
        boardPanel.updatePieces(controller.getBoard(), controller.getPlayersDirections());
    }

}
