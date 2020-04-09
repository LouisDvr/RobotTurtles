package fr.view;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class BoardPanel {

    private JPanel globalPanel = new JPanel();
    private JPanel boardPanel = new JPanel();
    private JPanel piecesPanel = new JPanel();

    BoardPanel() {
        configBoardPanel();
        globalPanel.add(boardPanel);
        initPiecesPanel();
        JPanel adjustedFeatures = adjustPiecesPanel();
        globalPanel.add(adjustedFeatures);
    }

    JPanel getPanel() {
        return globalPanel;
    }

    private void configBoardPanel() {
        JLabel backgroundPic = new JLabel(new ImageIcon("images/background.png"));
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
        left.setSize(28, 0);
        positionPanel.add(left, BorderLayout.WEST);

        JPanel right = new JPanel();
        right.setSize(28, 0);
        positionPanel.add(right, BorderLayout.EAST);

        JPanel top = new JPanel();
        top.setSize(0, 28);
        positionPanel.add(top, BorderLayout.NORTH);

        JPanel bottom = new JPanel();
        bottom.setSize(0, 28);
        positionPanel.add(bottom, BorderLayout.SOUTH);

        positionPanel.add(piecesPanel, BorderLayout.CENTER);

        return positionPanel;
    }

    void updatePieces(HashMap<Integer, String> squaresMap) {
        piecesPanel.removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        for (int key : squaresMap.keySet()) {
            gbc.gridx = key % 10;
            gbc.gridy = key / 10;
            piecesPanel.add(new GraphicPiece(squaresMap.get(key)));
        }
        piecesPanel.validate();
    }


    private class GraphicPiece extends JPanel {

        private JPanel piece = new JPanel();

        GraphicPiece(String name) {
            piece.setPreferredSize(new Dimension(58, 58));
            piece.setLayout(new BorderLayout());
            putImage(name);
        }

        private void putImage(String name) {
            JLabel piecePic;
            switch (name) {
                case "Player 1":
                    piecePic = new JLabel(new ImageIcon("images/turtles/BlueTurtle.png"));
                    piece.add(piecePic, BorderLayout.CENTER);
                    break;
                case "Player 2":
                    piecePic = new JLabel(new ImageIcon("images/turtles/RedTurtle.png"));
                    piece.add(piecePic, BorderLayout.CENTER);
                    break;
                case "Player 3":
                    piecePic = new JLabel(new ImageIcon("images/turtles/MagentaTurtle.png"));
                    piece.add(piecePic, BorderLayout.CENTER);
                    break;
                case "Player 4":
                    piecePic = new JLabel(new ImageIcon("images/turtles/GreenTurtle.png"));
                    piece.add(piecePic, BorderLayout.CENTER);
                    break;
                case "StoneWall":
                    piecePic = new JLabel(new ImageIcon("images/walls/StoneWall.png"));
                    piece.add(piecePic, BorderLayout.CENTER);
                    break;
                case "IceWall":
                    piecePic = new JLabel(new ImageIcon("images/walls/IceWall.png"));
                    piece.add(piecePic, BorderLayout.CENTER);
                    break;
                case "Jewel":
                    piecePic = new JLabel(new ImageIcon("images/Jewel.png"));
                    piece.add(piecePic, BorderLayout.CENTER);
                    break;
                default:
                    setOpaque(false);
                    break;
            }
        }
    }
}
