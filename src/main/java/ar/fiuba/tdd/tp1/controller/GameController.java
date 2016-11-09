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
    private static final String CANTUNDOMESSAGE = "No quedan movimientos para deshacer";
    private static final String CANUNDOMESSAGE =  "Se deshizo el ultimo movimiento";
    private String moveInfo;


    public GameController(String gameName,Game game) {
        this.gameName = gameName;
        this.game = game;
        this.gameWindow = null;
        this.alphabeticalCell = gameName.equalsIgnoreCase("gokigennaname") || gameName.equalsIgnoreCase("norinori");
        this.game.setAlphabeticalCell(this.alphabeticalCell);
        this.moveInfo = null;
    }

    public void run() {
        gameWindow = new GameWindow(this.gameName);
        createGUI(gameWindow);
        gameWindow.showGameWindow();
    }

    private void createGUI(GameWindow gameWindow) {
        UserInputHandler userInputHandler = new UserInputHandler();
        UndoButtonHandler undoButtonHandler = new UndoButtonHandler(getUndoMoveValue());
        userInputHandler.addObserver(this);
        undoButtonHandler.addObserver(this);
        int numberOfRows = this.game.getNumberOfRows();
        int numberOfColumns = this.game.getNumberOfColumns();
        List<String> validInputs = this.game.getValidInputs();
        List<CellInfo> cellInfoList = this.game.getCellsInfo();
        gameWindow.createGUI(numberOfRows,numberOfColumns,validInputs,cellInfoList,userInputHandler,undoButtonHandler);
    }


    @Override
    public void update(Observable observable, Object arg) {

        if (arg instanceof UndoButtonHandler) {
            undoMove(((UndoButtonHandler)arg));
        } else if (arg instanceof UserInputHandler) {
            applyMove(((UserInputHandler)arg));
        }
        this.gameWindow.updateMoveInfoField(moveInfo);
    }

    private void applyMove(UserInputHandler userInputHandler) {
        int cellId = userInputHandler.getCellId();
        String cellValue = userInputHandler.getValue();
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
    }

    private void undoMove(UndoButtonHandler undoButtonHandler) {

        if (game.getAppliedMovesCount() == 0) {
            moveInfo = CANTUNDOMESSAGE;
        } else {
            int cellId = game.getIdOfLastAppliedMove();
            game.undo(undoButtonHandler.getUndoValue());
            this.gameWindow.updateViewValue(cellId, undoButtonHandler.getUndoValue());
            moveInfo = CANUNDOMESSAGE;
        }
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

    private String getUndoMoveValue() {
        switch (this.gameName) {
            case "norinori":
                return "white";
            case "gokigennaname":
                return null;
            default:
                return "0";
        }
    }
}
