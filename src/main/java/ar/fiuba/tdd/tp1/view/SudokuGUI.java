package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.model.Game;

import java.awt.*;

public class SudokuGUI extends GameGUI {

    private Game gameModel;

    public SudokuGUI(Game gameModel) {
        super();
        this.gameModel = gameModel;
        this.drawBorder();
    }

    public void drawGUI(int rows, int columns, int subRegions) {

        this.setLayout(new GridLayout(0,3));
        for (int regionNumber = 1; regionNumber < subRegions + 1 ; regionNumber++) {
            this.add(new SubRegion(regionNumber, this.gameModel));
        }


    }

}
