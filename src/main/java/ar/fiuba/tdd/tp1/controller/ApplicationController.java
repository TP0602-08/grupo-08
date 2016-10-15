package ar.fiuba.tdd.tp1.controller;


import ar.fiuba.tdd.tp1.model.Game;
import ar.fiuba.tdd.tp1.serialization.json.GameJsonSerializer;
import ar.fiuba.tdd.tp1.serialization.xml.GameXmlSerializer;
import ar.fiuba.tdd.tp1.view.ApplicationView;
import ar.fiuba.tdd.tp1.view.ConfigFileErrorWindow;
import ar.fiuba.tdd.tp1.view.GameWindow;
import ar.fiuba.tdd.tp1.view.InvalidGameWindow;

import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.event.MouseInputAdapter;
import javax.xml.bind.JAXBException;

import static javax.swing.SwingUtilities.isLeftMouseButton;

public class ApplicationController extends MouseInputAdapter {

    private static String sudokuJsonPath = "src\\main\\resources\\sudoku.json";
    private static String kakuroJsonPath = "src\\main\\resources\\kakuro.json";

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
        return gameName.equals("sudoku") || gameName.equals("kakuro");
    }

    private GameJsonSerializer getGameJsonSerializer(String gameName) throws IOException {
        if (gameName.equalsIgnoreCase("sudoku")) {
            return new GameJsonSerializer(sudokuJsonPath);
        } else {
            return new GameJsonSerializer(kakuroJsonPath);
        }
    }

    private void initGame(String gameName, GameJsonSerializer gameJsonSerializer) {
        this.applicationView.dispose();
        game = gameJsonSerializer.deserialize();
        GameController gameController = new GameController(gameName,game);
        gameController.run();
    }


}
