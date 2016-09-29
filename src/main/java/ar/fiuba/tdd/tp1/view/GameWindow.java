package ar.fiuba.tdd.tp1.view;

import java.awt.*;
import javax.swing.*;


public class GameWindow extends JFrame {

    private GameGUI gameGUI;
    private GameButtonWindow gameButtonWindow;

    public GameWindow(String gameName) {
        super(gameName);
        this.setLayout(new FlowLayout());
        JMenuBar menuBar = new JMenuBar();
        JMenu menuBarFile = new JMenu("File");
        menuBar.add(menuBarFile);
        this.setSize(800,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setJMenuBar(menuBar);

       //create sudoku or kakuro gui here
        this.gameGUI = new SudokuGUI();
        gameGUI.drawGUI(9,9,9);
        this.gameButtonWindow = new GameButtonWindow();
        this.add(this.gameGUI);
        this.add(this.gameButtonWindow);
    }

    public void showGameWindow() {
        this.setVisible(true);
    }

}
