package ar.fiuba.tdd.tp1.view;


import ar.fiuba.tdd.tp1.controller.UserInputHandler;
import ar.fiuba.tdd.tp1.model.CellInfo;
import ar.fiuba.tdd.tp1.serialization.json.CellBorderJsonSerializer;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import javax.swing.*;
import javax.swing.border.MatteBorder;

abstract class GameGUI extends JPanel {

    protected String gameName;
    protected int numberOfRows;
    protected int numberOfColumns;
    protected List<String> validInputs;
    protected UserInputHandler userInputHandler;
    protected List<CellInfo> cellInfoList;

    protected GameGUI(String gameName, int numberOfRows, int numberOfColumns,
                      List<String> validInputs, List<CellInfo> cellInfoList, UserInputHandler
            userInputHandler) {
        this.gameName = gameName;
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.validInputs = validInputs;
        this.cellInfoList = cellInfoList;
        this.userInputHandler = userInputHandler;
        this.setLayout((new GridLayout(0, this.numberOfColumns)));
        this.drawBorder();
    }


    public void drawGUI() {
        for (CellInfo cellInfo : this.cellInfoList) {
            this.add(createNewCellView(cellInfo));
        }
        drawRegionBorders();
    }

    protected abstract CellView createNewCellView(CellInfo cellInfo);

    private void drawBorder() {
        this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
    }

    public void updateCell(int cellId, String value) {
        Component cell = this.getComponent(cellId - 1);
        ((CellView) cell).changeDisplayValue(value);
    }

    protected void drawRegionBorders() {
        CellBorderJsonSerializer cellBorderJsonSerializer = new CellBorderJsonSerializer(this.gameName);
        if (cellBorderJsonSerializer.fileExists()) {
            try {
                List<MatteBorder> borders = cellBorderJsonSerializer.getBorders();
                for (int i = 0; i < borders.size(); i++) {
                    this.getCellById(i).setBorder(borders.get(i));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    protected CellView getCellById(int id) {
        Component cell = this.getComponent(id);
        return ((CellView) cell);
    }
}
