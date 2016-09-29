package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.controller.CellController;

import java.awt.*;
import javax.swing.*;

public class KakuroCellView extends JButton{

    public KakuroCellView(String value, boolean editable) {
        super(value);
        if (editable) {
            this.setBackground(Color.WHITE);
            this.addMouseListener(new CellController());
        } else {
            this.setBackground(Color.BLACK);
            this.setEnabled(false);
        }
    }
}