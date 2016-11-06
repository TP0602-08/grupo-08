package ar.fiuba.tdd.tp1.controller;


import ar.fiuba.tdd.tp1.model.Game;
import ar.fiuba.tdd.tp1.serialization.json.GameJsonSerializer;
import ar.fiuba.tdd.tp1.view.ApplicationView;
import ar.fiuba.tdd.tp1.view.InvalidGameWindow;

import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.event.MouseInputAdapter;

import static javax.swing.SwingUtilities.isLeftMouseButton;

public class ApplicationController extends MouseInputAdapter {

    private static final String sudokuJsonPath = "src/main/resources/sudoku.json";
    private static final String kakuroJsonPath = "src/main/resources/kakuro.json";
    private static final String inshinoheshaJsonPath = "src/main/resources/inshinoheya.json";
    private static final String gokigenNanameJsonPath = "src/main/resources/gokigenNaname.json";
    private static final String norinoriJsonPath = "src/main/resources/norinori.json";

    private Game game;
    private GameJsonSerializer gameJsonSerializer;
    private ApplicationView applicationView;

    public void setView(ApplicationView applicationView) {
        this.applicationView = applicationView;
    }

    public void run() {
        this.applicationView.setVisible();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        String gameName;

        if (isLeftMouseButton(mouseEvent)) {
            gameName = this.applicationView.getTextField();
            if (validGameName(gameName.toLowerCase())) {
                try {
                    gameJsonSerializer = getGameJsonSerializer(gameName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                initGame(gameName, gameJsonSerializer);
            } else {
                new InvalidGameWindow();
            }
        }
    }

    private boolean validGameName(String gameName) {
        return gameName.equals("sudoku") || gameName.equals("kakuro")
                || gameName.equals("inshinoheya") || gameName.equals("gokigennaname") || gameName.equals("norinori");
    }

    private GameJsonSerializer getGameJsonSerializer(String gameName) throws IOException {
        switch (gameName) {
            case "sudoku":
                return new GameJsonSerializer(sudokuJsonPath);
            case "kakuro":
                return new GameJsonSerializer(kakuroJsonPath);
            case "inshinoheya":
                return new GameJsonSerializer(inshinoheshaJsonPath);
            case "gokigennaname":
                return new GameJsonSerializer(gokigenNanameJsonPath);
            default:
                return new GameJsonSerializer(norinoriJsonPath);

        }
    }

    private void initGame(String gameName, GameJsonSerializer gameJsonSerializer) {
        this.applicationView.dispose();
        game = gameJsonSerializer.deserialize();
        GameController gameController = new GameController(gameName,game);
        gameController.run();
    }


}
