package ar.fiuba.tdd.tp1.view;


import java.awt.*;
import javax.swing.*;

public abstract class GameGUI extends JPanel {

    public abstract void drawGUI(int rows, int columns, int subRegions);

    protected void drawBorder() {
        this.setBorder(BorderFactory.createLineBorder(Color.black, 5));
    }

}
