package ar.fiuba.tdd.tp1.view;

import java.awt.*;
import javax.swing.*;

public class SubGrid extends JPanel {

    public SubGrid(int numberOfColumns) {
        super();
        this.setLayout(new GridLayout(0, (int) Math.sqrt(numberOfColumns)));
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    public SudokuCellView find(int cellId) {
        SudokuCellView cell = null;
        for (Component cellComponent : this.getComponents()) {
            if (((SudokuCellView)cellComponent).getId() == cellId) {
                cell = ((SudokuCellView)cellComponent);
                break;
            }
        }
        return cell;
    }
}
