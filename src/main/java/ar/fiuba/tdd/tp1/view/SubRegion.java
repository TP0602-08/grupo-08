package ar.fiuba.tdd.tp1.view;


import java.awt.*;
import javax.swing.*;

public class SubRegion extends JPanel {

    public SubRegion() {
        //this class is temporal
        super();
        this.setLayout(new GridLayout(0,3));
        for (int i = 1; i < 10; i++) {
            this.add(new SudokuCellView(Integer.toString(i), true));
        }
        this.setBorder(BorderFactory.createLineBorder(Color.gray));
    }
}
