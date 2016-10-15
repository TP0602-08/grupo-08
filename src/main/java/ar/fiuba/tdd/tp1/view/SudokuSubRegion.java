package ar.fiuba.tdd.tp1.view;


import ar.fiuba.tdd.tp1.model.Cell;
import ar.fiuba.tdd.tp1.model.Game;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class SudokuSubRegion extends JPanel {

    private String regionId;
    private java.util.List<Integer> cellIdsList;

    public SudokuSubRegion(int regionNumber, Game gameModel) {
        super();
        this.regionId = "r" + Integer.toString(regionNumber);
        this.cellIdsList = gameModel.getCellsIdInRegion(regionId);
        this.setLayout(new GridLayout(0,3));
        boolean editable;
        for (Integer cellId : cellIdsList) {
            Cell cell = gameModel.getCell(cellId);
            //this.add(new SudokuCellView(cell));
        }
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }
}
