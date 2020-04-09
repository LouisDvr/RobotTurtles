package fr.view;

import javax.swing.*;
import java.awt.*;

class TransitionPanel {

    private Box panel = Box.createVerticalBox();
    private JLabel label = new JLabel();
    private JButton button = new JButton("Jouer !");

    TransitionPanel() {
        configLabel();
        panel.add(Box.createRigidArea(new Dimension(1, 45)));
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(1, 415)));
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(1, 120)));
    }

    private void configLabel() {
        label.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
        label.setForeground(Color.BLACK);
    }

    void setText(String text) {
        label.setText(text);
    }

    void setColor(Color color) {
        panel.setBackground(color);
    }

    Box getPanel() {
        return panel;
    }

}
