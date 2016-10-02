package ar.fiuba.tdd.tp1.controller;


import ar.fiuba.tdd.tp1.model.Game;
import ar.fiuba.tdd.tp1.serialization.xml.GameXmlSerializer;
import ar.fiuba.tdd.tp1.view.ApplicationView;
import ar.fiuba.tdd.tp1.view.GameWindow;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;
import javax.xml.bind.JAXBException;

import static javax.swing.SwingUtilities.isLeftMouseButton;

public class ApplicationController extends MouseInputAdapter {

    private Game game;
    private GameXmlSerializer gameXmlSerializer;
    private static String sudokuXMLPath = "src\\main\\resources\\sudoku.xml" ;
    private static String kakuroXMLPath = "src\\main\\resources\\kakuro.xml";

    private ApplicationView applicationView;

    public void setView(ApplicationView applicationView) {
        this.applicationView = applicationView;
        this.applicationView.addController(this);
    }

    public void run() {
        this.applicationView.setVisible();
    }

    @Override
    public  void mouseClicked(MouseEvent mouseEvent) {
        String gameName;

        if (isLeftMouseButton(mouseEvent)) {
            gameName = this.applicationView.getTextField();
            System.out.println("game name: " + gameName);
            if (validGameName(gameName.toLowerCase())) {
                gameXmlSerializer = new GameXmlSerializer(sudokuXMLPath);
                try {
                    game = gameXmlSerializer.deserialize();
                    System.out.println("game created");
                } catch (JAXBException e) {
                    //todo define what happens when there is no xml
                    e.printStackTrace();
                }
                this.applicationView.dispose();
                initGame(gameName, game);
            }
        }
    }

    private void initGame(String gameName, Game game) {
        //gamename can be obtained from model
        GameWindow gameWindow = new GameWindow(gameName, game);
        gameWindow.showGameWindow();
    }

    private boolean validGameName(String gameName) {

        return gameName.equals("sudoku") || gameName.equals("kakuro");
    }
}
