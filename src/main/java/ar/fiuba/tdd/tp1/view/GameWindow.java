package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.model.Game;

import java.awt.*;
import javax.swing.*;


public class GameWindow extends JFrame {

    private GameGUI gameGUI;
    private GameButtonWindow gameButtonWindow;
    private String gameName;
    private Game gameModel;

    public GameWindow(String gameName, Game gameModel) {
        super(gameName);
        this.gameName = gameName;
        this.gameModel = gameModel;
        this.setLayout(new FlowLayout());
        JMenuBar menuBar = new JMenuBar();
        JMenu menuBarFile = new JMenu("File");
        menuBar.add(menuBarFile);
        this.setSize(800,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setJMenuBar(menuBar);
        this.createGUI(this.gameName);
    }

    public void showGameWindow() {
        this.setVisible(true);
    }

    private void createGUI(String gameName) {
        if (gameName.equalsIgnoreCase("Sudoku")) {
            this.gameGUI = new SudokuGUI(this.gameModel);
            //regions hardcoding temporal
            gameGUI.drawGUI(this.gameModel.getNumberOfRows(),this.gameModel.getNumberOfColumns(),this.gameModel.getNumberOfColumns());
            this.gameButtonWindow = new GameButtonWindow();
            this.add(this.gameGUI);
            this.add(this.gameButtonWindow);
        }

        if (gameName.equalsIgnoreCase("Kakuro")) {
            this.gameGUI = new KakuroGUI(this.gameModel);
            gameGUI.drawGUI(this.gameModel.getNumberOfRows(),this.gameModel.getNumberOfColumns(),1);
            this.gameButtonWindow = new GameButtonWindow();
            this.add(this.gameGUI);
            this.add(this.gameButtonWindow);
        }
    }
}
