package fr.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class BoardPanel {

    private JPanel globalPanel = new JPanel();
    private JPanel boardPanel = new JPanel();
    private JPanel piecesPanel = new JPanel();

    BoardPanel() {
        configBoardPanel();
        globalPanel.add(boardPanel);
        initPiecesPanel();
        JPanel adjustedPanel = adjustPiecesPanel();
        globalPanel.add(adjustedPanel);
    }

    JPanel getPanel() {
        return globalPanel;
    }

    private void configBoardPanel() {
        JLabel backgroundPic = new JLabel(new ImageIcon("src/fr/view/images/background.png"));
        boardPanel.setLayout(new BorderLayout());
        boardPanel.add(backgroundPic, BorderLayout.CENTER);
    }

    private void initPiecesPanel() {
        piecesPanel.setPreferredSize(new Dimension(464, 464));
        piecesPanel.setOpaque(false);
        piecesPanel.setLayout(new GridBagLayout());
    }

    private JPanel adjustPiecesPanel() {
        //aims at positioning the feature panel correctly because of the edges of the board image
        JPanel positionPanel = new JPanel();
        positionPanel.setLayout(new BorderLayout());

        JPanel left = new JPanel();
        left.setSize(28, 1);
        positionPanel.add(left, BorderLayout.WEST);

        JPanel right = new JPanel();
        right.setSize(28, 1);
        positionPanel.add(right, BorderLayout.EAST);

        JPanel top = new JPanel();
        top.setSize(1, 28);
        positionPanel.add(top, BorderLayout.NORTH);

        JPanel bottom = new JPanel();
        bottom.setSize(1, 28);
        positionPanel.add(bottom, BorderLayout.SOUTH);

        positionPanel.add(piecesPanel, BorderLayout.CENTER);

        return positionPanel;
    }

    void updatePieces(HashMap<Integer, String> squaresMap, ArrayList<String> directions) {
        piecesPanel.removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        for (int key : squaresMap.keySet()) {
            gbc.gridx = key % 10;
            gbc.gridy = key / 10;
            String name = squaresMap.get(key);
            if (name.substring(0,2).equals("Pl")) {
                int playerNumber = name.charAt(name.length()-1);
                piecesPanel.add(new GraphicPiece(name, directions.get(playerNumber-1)));
            }
            else piecesPanel.add(new GraphicPiece(name));
        }
        piecesPanel.validate();
    }


    private static class GraphicPiece extends JPanel {

        private JPanel piece = new JPanel();

        GraphicPiece(String name) {
            piece.setPreferredSize(new Dimension(58, 58));
            piece.setLayout(new BorderLayout());
            putImage(name);
        }

        GraphicPiece(String name, String direction) {
            piece.setPreferredSize(new Dimension(58, 58));
            piece.setLayout(new BorderLayout());
            putImage(name, direction);
        }

        private void putImage(String name) {
            JLabel piecePic;
            switch (name) {
                case "StoneWall":
                    piecePic = new JLabel(new ImageIcon("src/fr/view/images/walls/StoneWall.png"));
                    piece.add(piecePic, BorderLayout.CENTER);
                    break;
                case "IceWall":
                    piecePic = new JLabel(new ImageIcon("src/fr/view/images/walls/IceWall.png"));
                    piece.add(piecePic, BorderLayout.CENTER);
                    break;
                case "Jewel":
                    piecePic = new JLabel(new ImageIcon("src/fr/view/images/Jewel.png"));
                    piece.add(piecePic, BorderLayout.CENTER);
                    break;
                default:
                    break;
            }
        }

        private void putImage(String name, String direction) {
            JLabel piecePic;
            switch (name) {
                case "Player 1":
                    piecePic = new JLabel(new ImageIcon("src/fr/view/images/turtles/blueTurtle/BlueTurtle"+direction+".png"));
                    piece.add(piecePic, BorderLayout.CENTER);
                    break;
                case "Player 2":
                    piecePic = new JLabel(new ImageIcon("src/fr/view/images/turtles/redTurtle/RedTurtle"+direction+".png"));
                    piece.add(piecePic, BorderLayout.CENTER);
                    break;
                case "Player 3":
                    piecePic = new JLabel(new ImageIcon("src/fr/view/images/turtles/magentaTurtle/MagentaTurtle"+direction+".png"));
                    piece.add(piecePic, BorderLayout.CENTER);
                    break;
                case "Player 4":
                    piecePic = new JLabel(new ImageIcon("src/fr/view/images/turtles/greenTurtle/GreenTurtle"+direction+".png"));
                    piece.add(piecePic, BorderLayout.CENTER);
                    break;
                default:
                    break;
            }
        }
    }
}
