package ar.fiuba.tdd.tp1.controller;

import ar.fiuba.tdd.tp1.model.*;
import ar.fiuba.tdd.tp1.view.GameWindow;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class GameController implements Observer {

    private String gameName;
    private Game game;
    private GameWindow gameWindow;
    private boolean alphabeticalCell;
    private static final String VALIDMOVEMESSAGE = "Movimiento valido";
    private static final String GAMEWONMESSAGE = "Movimiento valido, juego ganado";

    public GameController(String gameName,Game game) {
        this.gameName = gameName;
        this.game = game;
        this.gameWindow = null;
        this.alphabeticalCell = gameName.equalsIgnoreCase("gokigennaname");
    }

    public void run() {
        gameWindow = new GameWindow(this.gameName);
        createGUI(gameWindow);
        gameWindow.showGameWindow();
    }

    private void createGUI(GameWindow gameWindow) {
        UserInputHandler userInputHandler = new UserInputHandler();
        userInputHandler.addObserver(this);
        int numberOfRows = this.game.getNumberOfRows();
        int numberOfColumns = this.game.getNumberOfColumns();
        List<String> validInputs = this.game.getValidInputs();
        List<CellInfo> cellInfoList = this.game.getCellsInfo();
        gameWindow.createGUI(numberOfRows,numberOfColumns,validInputs,cellInfoList,userInputHandler);
    }


    @Override
    public void update(Observable observable, Object arg) {
        int cellId = ((UserInputHandler)arg).getCellId();
        String cellValue = ((UserInputHandler)arg).getValue();
        String moveInfo;

        Move newMove = createMove(cellId,cellValue);
        this.game.process(newMove);
        if (newMove.isValid()) {
            this.gameWindow.updateViewValue(cellId,cellValue);
            moveInfo = VALIDMOVEMESSAGE;
            if (this.game.isGameWon()) {
                moveInfo = GAMEWONMESSAGE;
            }
        } else {
            moveInfo = newMove.getListOfViolationsOfRules().get(0).getExplanation();
        }

        this.gameWindow.updateMoveInfoField(moveInfo);
    }

    private Move createMove(int cellId,String cellValue) {
        Cell cell;
        if (this.alphabeticalCell) {
            if (cellValue.equals("\\")) {
                cellValue = "\\";
            }
            cell = new CellAlphabetical(cellValue,Integer.toString(cellId));
        } else {
            cell = new CellNumerical(Integer.parseInt(cellValue),Integer.toString(cellId));
        }

        return new Move(cellId,cell);
    }
}
