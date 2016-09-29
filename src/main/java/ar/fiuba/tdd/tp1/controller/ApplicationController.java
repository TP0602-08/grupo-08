package ar.fiuba.tdd.tp1.controller;


import ar.fiuba.tdd.tp1.view.ApplicationView;
import ar.fiuba.tdd.tp1.view.GameWindow;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

import static javax.swing.SwingUtilities.isLeftMouseButton;

public class ApplicationController extends MouseInputAdapter {

    //private model
    private ApplicationView applicationView;

    public void setView(ApplicationView applicationView) {
        /* maybe this should be moved to constructor
        once model is finished
         */
        this.applicationView = applicationView;
        this.applicationView.addController(this);
    }

    public void run() {
        this.applicationView.setVisible();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        String configFilePath;

        if (isLeftMouseButton(mouseEvent)) {
            configFilePath = this.applicationView.getTextField();
            System.out.println("config path: " + configFilePath);
            //once finished model checks the path
            //if it's correct creates the game and controller creates a gameview
            //if its' not controller shows error window
            this.applicationView.dispose();
            initGame("Sudoku");
        }
    }

    private void initGame(String gameName) {
        //gamename can be obtained from model
        //uncomment next line to force kakuro game
        //gameName = "Kakuro";
        GameWindow gameWindow = new GameWindow(gameName);
        gameWindow.showGameWindow();
    }
}
