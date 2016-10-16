package ar.fiuba.tdd.tp1.controller;

import ar.fiuba.tdd.tp1.model.CellInfo;
import ar.fiuba.tdd.tp1.model.CellNumerical;
import ar.fiuba.tdd.tp1.model.Game;
import ar.fiuba.tdd.tp1.model.Move;
import ar.fiuba.tdd.tp1.view.GameWindow;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class GameController implements Observer {

    private String gameName;
    private Game game;
    private GameWindow gameWindow;

    public GameController(String gameName,Game game) {
        this.gameName = gameName;
        this.game = game;
        this.gameWindow = null;
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
        List<Integer> validInputs = this.game.getValidInputs();
        List<CellInfo> cellInfoList = this.game.getCellsInfo();
        gameWindow.createGUI(numberOfRows,numberOfColumns,validInputs,cellInfoList,userInputHandler);
    }


    @Override
    public void update(Observable observable, Object arg) {
        int cellId = ((UserInputHandler)arg).getCellId();
        int cellValue = ((UserInputHandler)arg).getValue();
        String moveInfo;

        Move newMove = new Move(cellId,new CellNumerical(cellValue,Integer.toString(cellId)));
        this.game.process(newMove);
        if (newMove.isValid()) {
            this.gameWindow.updateViewValue(cellId,cellValue);
            moveInfo = "Movimiento valido";
        } else {
            moveInfo = newMove.getListOfViolationsOfRules().get(0).getExplanation();
        }

        this.gameWindow.updateMoveInfoField(moveInfo);
    }
}
