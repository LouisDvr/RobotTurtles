package fr.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class TitleScreen {

    private Box titleScreen = Box.createVerticalBox();
    private JButton button2P = new JButton("2 joueurs");
    private JButton button3P = new JButton("3 joueurs");
    private JButton button4P = new JButton("4 joueurs");
    private JLabel playButton = new JLabel(new ImageIcon("src/fr/view/images/PlayButton.png"));
    private int nbOfPlayers = 0;

    TitleScreen(MouseListener mouseListener) {
        titleScreen.setBackground(new Color(92, 235, 124));
        titleScreen.add(Box.createGlue());
        JLabel title = new JLabel(new ImageIcon("src/fr/view/images/Title.png"));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleScreen.add(title);
        titleScreen.add(Box.createGlue());
        //beginning of the buttonBox config
        Box buttonBox = Box.createHorizontalBox();
        buttonBox.add(Box.createGlue());
        //part dealing wit button2P config
        configButton(button2P);
        button2P.addActionListener(new B2PListener());
        buttonBox.add(button2P);

        buttonBox.add(Box.createGlue());
        //part dealing with button3P config
        configButton(button3P);
        button3P.addActionListener(new B3PListener());
        buttonBox.add(button3P);

        buttonBox.add(Box.createGlue());
        //part dealing with button4P config
        configButton(button4P);
        button4P.addActionListener(new B4PListener());
        buttonBox.add(button4P);

        buttonBox.add(Box.createGlue());
        titleScreen.add(buttonBox); //end of the buttonBox config

        titleScreen.add(Box.createGlue());
        //part dealing with playButton config
        playButton.setPreferredSize(new Dimension(150, 150));
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        playButton.addMouseListener(mouseListener);
        titleScreen.add(playButton);

        titleScreen.add(Box.createGlue());
    }

    private void configButton(JButton button) {
        button.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
        unselectButton(button);
    }

    private void unselectButton(JButton button) {
        button.setBackground(new Color(41, 164, 36));
        button.setEnabled(true);
    }

    private void selectButton(JButton button) {
        button.setBackground(new Color(75, 105, 51));
        button.setEnabled(false);
    }

    JPanel getPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(titleScreen, BorderLayout.CENTER);
        return panel;
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
