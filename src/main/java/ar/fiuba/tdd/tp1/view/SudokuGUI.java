package ar.fiuba.tdd.tp1.view;

import java.awt.*;
import javax.swing.*;

public class SudokuGUI extends GameGUI {

    public SudokuGUI() {
        super();
        this.drawBorder();
    }

    public void drawGUI(int rows, int columns, int subRegions) {

        this.setLayout(new GridLayout(0,3));
        for (int i = 0; i < subRegions; i++) {
            this.add(new SubRegion());
        }


    }

}
