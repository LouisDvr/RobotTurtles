package fr.view;

import javax.swing.*;
import java.awt.*;

public class CardPanel {

    Box cardPanel = Box.createHorizontalBox();
    JButton card1 = new JButton();
    JButton card2 = new JButton();
    JButton card3 = new JButton();
    JButton card4 = new JButton();
    JButton card5 = new JButton();
    JButton stoneWall = new JButton();
    JLabel swNb = new JLabel();
    JButton iceWall = new JButton();
    JLabel iwNb = new JLabel();
    JButton validate = new JButton("Valider");

    CardPanel() {

    }

    private void configButtons() {
        card1.setPreferredSize(new Dimension(115, 162));
        card2.setPreferredSize(new Dimension(115, 162));
        card3.setPreferredSize(new Dimension(115, 162));
        card4.setPreferredSize(new Dimension(115, 162));
    }
}
