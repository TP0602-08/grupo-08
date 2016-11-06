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

        gameGUI = getGameGUI(numberOfRows,numberOfColumns,validInputs,cellInfoList,userInputHandler);

        if (gameGUI != null) {
            gameGUI.drawGUI();
            this.moveInformationField = new MoveInformationField();
            this.add(this.gameGUI);
            this.add(this.moveInformationField);
        }
    }

    private GameGUI getGameGUI(int numberOfRows, int numberOfColumns, List<String> validInputs,
                               List<CellInfo> cellInfoList, UserInputHandler userInputHandler) {
        switch (this.gameName) {
            case "sudoku":
                return new SudokuGUI(this.gameName,numberOfRows,numberOfColumns,validInputs,cellInfoList,userInputHandler);
            case "kakuro":
                return new KakuroGUI(this.gameName,numberOfRows,numberOfColumns,validInputs,cellInfoList,userInputHandler);
            case "inshinoheya":
                return new InshiNoHeyaGUI(this.gameName,numberOfRows,numberOfColumns,validInputs,cellInfoList,userInputHandler);
            case "gokigennaname":
                return new GokigenNanameGUI(this.gameName,numberOfRows,numberOfColumns,validInputs,cellInfoList,userInputHandler);
            default:
                return new NorinoriGUI(this.gameName,numberOfRows,numberOfColumns,validInputs,cellInfoList,userInputHandler);
        }
    }

    public void updateViewValue(int cellId, String value) {
        this.gameGUI.updateCell(cellId,value);
    }

    public void updateMoveInfoField(String info) {
        this.moveInformationField.setText(info);
    }


}
