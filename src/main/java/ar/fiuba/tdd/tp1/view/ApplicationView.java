package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.controller.ApplicationController;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;


public class ApplicationView extends JFrame {

    private JPanel gamesPanel;
    private JLabel imageLabel;
    private ApplicationController applicationController;
    private java.util.List<String> supportedGames = Arrays.asList("Sudoku", "Kakuro", "Inshi No Heya", "Gokigen Naname", "Norinori");
    private static final int GRIDLAYOUTROWS = 0;
    private static final int GRIDLAYOUTCOLUMNS = 3;

    public ApplicationView() {
        super("GameEngine - Group8");
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.imageLabel = new JLabel(new ImageIcon("src/main/resources/LogoFiuba.jpg"));
        this.add(imageLabel);
        this.gamesPanel = new JPanel();
        this.gamesPanel.setLayout(new GridLayout(GRIDLAYOUTROWS,GRIDLAYOUTCOLUMNS));
        TitledBorder titledBorder = new TitledBorder("Select game ");
        this.gamesPanel.setBorder(titledBorder);
        this.add(gamesPanel);
        this.applicationController = null;
    }

    private void fillGamesPanel() {
        for (String supportedGame : supportedGames) {
            JButton gameButton = new JButton(supportedGame);
            gameButton.addMouseListener(this.applicationController);
            this.gamesPanel.add(gameButton);
        }
    }

    public void setVisible() {
        this.setVisible(true);
    }

    public void dismissView() {
        this.dispose();
    }

    public void setController(ApplicationController applicationController) {
        this.applicationController = applicationController;
        fillGamesPanel();

    }
}
