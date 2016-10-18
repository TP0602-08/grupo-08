package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.controller.UserInputHandler;
import ar.fiuba.tdd.tp1.model.CellInfo;

import java.awt.*;
import java.util.List;
import javax.swing.*;


public class GameWindow extends JFrame {

    private GameGUI gameGUI;
    private MoveInformationField moveInformationField;
    private String gameName;

    public GameWindow(String gameName)  {
        super(gameName);
        this.gameName = gameName;
        this.setLayout(new FlowLayout());
        this.setSize(800,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showGameWindow() {
        this.setVisible(true);
    }

    public void createGUI(int numberOfRows, int numberOfColumns, List<String> validInputs, List<CellInfo> cellInfoList, UserInputHandler
            userInputHandler) {


        gameGUI = getGameGUI(this.gameName,numberOfRows,numberOfColumns,validInputs,cellInfoList,userInputHandler);

        if (gameGUI != null) {
            gameGUI.drawGUI();
            this.moveInformationField = new MoveInformationField();
            this.add(this.gameGUI);
            this.add(this.moveInformationField);
        }
    }

    private GameGUI getGameGUI(String gameName, int numberOfRows, int numberOfColumns, List<String> validInputs,
                               List<CellInfo> cellInfoList, UserInputHandler userInputHandler) {

        if (this.gameName.equalsIgnoreCase("Sudoku")) {
            return new SudokuGUI(numberOfRows,numberOfColumns,validInputs,cellInfoList,userInputHandler);
        }

        if (this.gameName.equalsIgnoreCase("Kakuro")) {
            return new KakuroGUI(numberOfRows,numberOfColumns,validInputs,cellInfoList,userInputHandler);
        } else {
            return new InshiNoHeyaGUI(numberOfRows,numberOfColumns,validInputs,cellInfoList,userInputHandler);
        }
    }

    public void updateViewValue(int cellId, int value) {
        this.gameGUI.updateCell(cellId,value);
    }

    public void updateMoveInfoField(String info) {
        this.moveInformationField.setText(info);
    }


}
