package ar.fiuba.tdd.tp1.view;

import java.awt.*;
import javax.swing.*;


public class GameWindow extends JFrame {

    private GameGUI gameGUI;
    private GameButtonWindow gameButtonWindow;
    private String gameName;

    public GameWindow(String gameName) {
        super(gameName);
        this.gameName = gameName;
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
        if (gameName.equals("Sudoku")) {
            this.gameGUI = new SudokuGUI();
            gameGUI.drawGUI(9,9,9);
            this.gameButtonWindow = new GameButtonWindow();
            this.add(this.gameGUI);
            this.add(this.gameButtonWindow);
        }

        if (gameName.equals("Kakuro")) {
            this.gameGUI = new KakuroGUI();
            gameGUI.drawGUI(4,3,1);
            this.gameButtonWindow = new GameButtonWindow();
            this.add(this.gameGUI);
            this.add(this.gameButtonWindow);
        }
    }
}
