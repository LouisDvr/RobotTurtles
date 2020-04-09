package fr.view;

import javax.swing.*;
import java.awt.*;

public class ActionPanel {

    private Box actionPanel = Box.createVerticalBox();
    private JButton addCards = new JButton("Ajouter des cartes au programme");
    private JButton executeProgram = new JButton("Executer le programme");
    private JButton buildWall = new JButton("Construire un mur");
    private JButton pass = new JButton("Ne rien faire et passer à la phase de défausse");

    ActionPanel() {
        actionPanel.setBackground(new Color(54, 236, 80));
        actionPanel.add(Box.createRigidArea(new Dimension(1, 100)));
        actionPanel.add(addCards);
        actionPanel.add(Box.createRigidArea(new Dimension(1, 40)));
        actionPanel.add(executeProgram);
        actionPanel.add(Box.createRigidArea(new Dimension(1, 40)));
        actionPanel.add(buildWall);
        actionPanel.add(Box.createRigidArea(new Dimension(1, 40)));
        actionPanel.add(pass);
        actionPanel.add(Box.createRigidArea(new Dimension(1, 100)));
    }
}
