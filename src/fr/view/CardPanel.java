package fr.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CardPanel {

    Box cardPanel = Box.createHorizontalBox();
    JButton card1 = new JButton();
    JButton card2 = new JButton();
    JButton card3 = new JButton();
    JButton card4 = new JButton();
    JButton card5 = new JButton();
    JButton stoneWall = new JButton();
    JLabel nbStoneWall = new JLabel(" x3");
    JButton iceWall = new JButton();
    JLabel nbIceWall = new JLabel(" x2");
    JButton validate = new JButton("Valider");

    CardPanel() {
        //adds the cards
        configCards();
        cardPanel.add(Box.createGlue());
        cardPanel.add(card1);
        cardPanel.add(Box.createGlue());
        cardPanel.add(card2);
        cardPanel.add(Box.createGlue());
        cardPanel.add(card3);
        cardPanel.add(Box.createGlue());
        cardPanel.add(card4);
        cardPanel.add(Box.createGlue());
        cardPanel.add(card5);
        cardPanel.add(Box.createGlue());

        //adds the walls
        Box walls = Box.createVerticalBox();
        walls.add(configWallButton(stoneWall, "src/fr/view/images/walls/StoneWall.png", nbStoneWall));
        walls.add(Box.createGlue());
        walls.add(configWallButton(iceWall, "src/fr/view/images/walls/IceWall.png", nbIceWall));
        cardPanel.add(walls);
        cardPanel.add(Box.createGlue());

        //adds the validate button
        validate.setPreferredSize(new Dimension(115, 60));
        cardPanel.add(validate);
        cardPanel.add(Box.createGlue());
    }

    private void configCards() {
        card1.setPreferredSize(new Dimension(115, 162));
        card1.setLayout(new BorderLayout());
        card2.setPreferredSize(new Dimension(115, 162));
        card2.setLayout(new BorderLayout());
        card3.setPreferredSize(new Dimension(115, 162));
        card3.setLayout(new BorderLayout());
        card4.setPreferredSize(new Dimension(115, 162));
        card4.setLayout(new BorderLayout());
        card5.setPreferredSize(new Dimension(115, 162));
        card5.setLayout(new BorderLayout());
    }

    private Box configWallButton(JButton button, String imgPath, JLabel label) {
        //first, configures the button
        button.setPreferredSize(new Dimension(75, 75));
        button.setLayout(new BorderLayout());
        JLabel backgroundPic = new JLabel(new ImageIcon(imgPath));
        button.add(backgroundPic, BorderLayout.CENTER);

        //then, configures the label
        label.setFont(new Font("Trebuchet MS", Font.BOLD, 16));

        //finally, adds them to the box
        Box box = Box.createHorizontalBox();
        box.setPreferredSize(new Dimension(150, 75));
        box.add(button);
        box.add(label);

        return box;
    }

    void setCardsImages(ArrayList<String> hand) {
        for (int i = 0; i < (Math.min(hand.size(), 5)); ++i) { //the size of the hand should be 5 but caution
            switch (i) {
                case 0:
                    setCardImage(card1, hand.get(i));
                    break;
                case 1:
                    setCardImage(card2, hand.get(i));
                    break;
                case 2:
                    setCardImage(card3, hand.get(i));
                    break;
                case 3:
                    setCardImage(card4, hand.get(i));
                    break;
                case 4:
                    setCardImage(card5, hand.get(i));
                    break;
                default:
                    break;
            }
        }
        cardPanel.validate();
    }

    private void setCardImage(JButton card, String cardType) {
        JLabel cardPic;
        switch (cardType) {
            case "Forward":
                cardPic = new JLabel(new ImageIcon("src/fr/view/images/cards/BlueCard.png"));
                break;
            case "Left":
                cardPic = new JLabel(new ImageIcon("src/fr/view/images/cards/YellowCard.png"));
                break;
            case "Right":
                cardPic = new JLabel(new ImageIcon("src/fr/view/images/cards/PurpleCard.png"));
                break;
            case "Laser":
                cardPic = new JLabel(new ImageIcon("src/fr/view/images/cards/LaserCard.png"));
                break;
            default:
                cardPic = new JLabel("Erreur !");
                break;
        }
        card.add(cardPic, BorderLayout.CENTER);
    }

    void setWallNb(String type, int nb) {
        if (type.equals("StoneWall")) nbStoneWall.setText(" x"+nb);
        else nbIceWall.setText(" x"+nb);
        cardPanel.validate();
    }

    Box getPanel() {
        return cardPanel;
    }
}
