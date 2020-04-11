package fr.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreen {

    private Box titleScreen = Box.createVerticalBox();
    private JButton button2P = new JButton("2 joueurs");
    private JButton button3P = new JButton("3 joueurs");
    private JButton button4P = new JButton("4 joueurs");
    private int nbOfPlayers = 0;

    TitleScreen() {
        titleScreen.setBackground(new Color(190, 200, 170));
        titleScreen.add(Box.createRigidArea(new Dimension(1, 150)));
        JLabel title = new JLabel(new ImageIcon("images/Title.png"));
        titleScreen.add(title);
        titleScreen.add(Box.createRigidArea(new Dimension(1, 78)));
        //beginning of the buttonBox config
        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(Box.createRigidArea(new Dimension(150, 1)));
        //part dealing wit button2P config
        configButton(button2P);
        button2P.addActionListener(new B2PListener());
        buttonBox.add(button2P);

        buttonBox.add(Box.createRigidArea(new Dimension(150, 1)));
        //part dealing with button3P config
        configButton(button3P);
        button3P.addActionListener(new B3PListener());
        buttonBox.add(button3P);

        buttonBox.add(Box.createRigidArea(new Dimension(150, 1)));
        //part dealing with button4P config
        configButton(button4P);
        button4P.addActionListener(new B4PListener());
        buttonBox.add(button4P);

        buttonBox.add(Box.createRigidArea(new Dimension(150, 1)));
        titleScreen.add(buttonBox); //end of the buttonBox config

        titleScreen.add(Box.createRigidArea(new Dimension(1, 55)));
        //part dealing with playButton config
        JLabel playButton = new JLabel(new ImageIcon("images/PlayButton.png"));
        playButton.setPreferredSize(new Dimension(100, 100));
        titleScreen.add(playButton);

        titleScreen.add(Box.createRigidArea(new Dimension(1, 50)));
    }

    private void configButton(JButton button) {
        button.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
        unselectButton(button);
    }

    private void unselectButton(JButton button) {
        button.setBackground(new Color(92, 235, 124));
        button.setEnabled(true);
    }

    private void selectButton(JButton button) {
        button.setBackground(new Color(75, 105, 51));
        button.setEnabled(false);
    }

    Box getPanel() {
        return titleScreen;
    }

    int getNbOfPlayers() {
        return nbOfPlayers;
    }


    private class B2PListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            nbOfPlayers = 2;
            selectButton(button2P);
            //unselect the other buttons in case one of them was selected
            unselectButton(button3P);
            unselectButton(button4P);
        }
    }

    private class B3PListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            nbOfPlayers = 3;
            selectButton(button3P);
            //unselect the other buttons in case one of them was selected
            unselectButton(button2P);
            unselectButton(button4P);
        }
    }

    private class B4PListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            nbOfPlayers = 4;
            selectButton(button4P);
            //unselect the other buttons in case one of them was selected
            unselectButton(button2P);
            unselectButton(button3P);
        }
    }

}
