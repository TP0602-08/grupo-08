package ar.fiuba.tdd.tp1.controller;


import ar.fiuba.tdd.tp1.model.Game;
import ar.fiuba.tdd.tp1.serialization.GameXmlSerializer;
import ar.fiuba.tdd.tp1.view.ApplicationView;
import ar.fiuba.tdd.tp1.view.ConfigFileErrorWindow;
import ar.fiuba.tdd.tp1.view.GameWindow;
import ar.fiuba.tdd.tp1.view.InvalidGameWindow;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;
import javax.xml.bind.JAXBException;

import static javax.swing.SwingUtilities.isLeftMouseButton;

public class ApplicationController extends MouseInputAdapter {

    private static String sudokuXMLPath = "src\\main\\resources\\sudoku.xml";
    private static String kakuroXMLPath = "src\\main\\resources\\kakuro.xml";

    private Game game;
    private GameXmlSerializer gameXmlSerializer;
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
                gameXmlSerializer = getXMlSerializer(gameName);
                initGame(gameName, gameXmlSerializer);
            } else {
                new InvalidGameWindow();
            }
        }
    }

    private boolean validGameName(String gameName) {
        return gameName.equals("sudoku") || gameName.equals("kakuro");
    }

    private GameXmlSerializer getXMlSerializer(String gameName) {
        if (gameName.equalsIgnoreCase("sudoku")) {
            return new GameXmlSerializer(sudokuXMLPath);
        } else {
            return new GameXmlSerializer(kakuroXMLPath);
        }
    }

    private void initGame(String gameName, GameXmlSerializer gameXmlSerializer) {
        try {
            game = gameXmlSerializer.deserialize();
            this.applicationView.dispose();
            runGame(gameName, game);
        } catch (JAXBException e) {
            new ConfigFileErrorWindow(gameName.toLowerCase());
        }
    }

    private void runGame(String gameName, Game game) {
        GameWindow gameWindow = new GameWindow(gameName, game);
        gameWindow.showGameWindow();
    }
}
