package fr.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class TransitionPanel {

    private Box panel = Box.createVerticalBox();
    private JLabel label = new JLabel();
    private JButton button = new JButton();

    TransitionPanel(ActionListener actionListener) {
        configLabel();
        panel.add(Box.createRigidArea(new Dimension(1, 45)));
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(1, 415)));
        configButton();
        button.addActionListener(actionListener);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(1, 70)));
    }

    private void configLabel() {
        label.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
        label.setForeground(Color.BLACK);
    }

    private void configButton() {
        button.setPreferredSize(new Dimension(100, 100));
        button.setLayout(new BorderLayout());
        JLabel pic = new JLabel(new ImageIcon("images/PlayButton.png"));
        button.add(pic, BorderLayout.CENTER);
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
