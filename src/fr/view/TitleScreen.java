package fr.view;

import javax.swing.*;
import java.awt.*;

public class TitleScreen {

    private Box titleScreen = Box.createVerticalBox();
    private JButton button2P = new JButton("2 joueurs");
    private JButton button3P = new JButton("3 joueurs");
    private JButton button4P = new JButton("4 joueurs");

    TitleScreen() {
        titleScreen.setBackground(new Color(190, 200, 170));
        titleScreen.add(Box.createRigidArea(new Dimension(1, 150)));
        JLabel title = new JLabel(new ImageIcon("images/Title.png"));
        titleScreen.add(title);
        titleScreen.add(Box.createRigidArea(new Dimension(1, 78)));

        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(Box.createRigidArea(new Dimension(150, 1)));
        configButton(button2P);
        buttonBox.add(button2P);
        buttonBox.add(Box.createRigidArea(new Dimension(150, 1)));
        configButton(button3P);
        buttonBox.add(button3P);
        buttonBox.add(Box.createRigidArea(new Dimension(150, 1)));
        configButton(button4P);
        buttonBox.add(button4P);
        buttonBox.add(Box.createRigidArea(new Dimension(150, 1)));

        titleScreen.add(buttonBox);
        titleScreen.add(Box.createRigidArea(new Dimension(1, 55)));
        JLabel playButton = new JLabel(new ImageIcon("images/PlayButton.png"));
        playButton.setPreferredSize(new Dimension(100, 100));
        titleScreen.add(playButton);
        titleScreen.add(Box.createRigidArea(new Dimension(1, 50)));
    }

    private void configButton(JButton button) {
        button.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        button.setBackground(new Color(92, 235, 124));
    }

    Box getPanel() {
        return titleScreen;
    }
}
