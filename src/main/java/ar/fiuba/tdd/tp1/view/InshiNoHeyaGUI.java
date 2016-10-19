package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.controller.UserInputHandler;
import ar.fiuba.tdd.tp1.model.CellInfo;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;

public class InshiNoHeyaGUI extends GameGUI {

    private boolean regions;

    public InshiNoHeyaGUI(int numberOfRows, int numberOfColumns, List<String> validInputs, List<CellInfo> cellInfoList, UserInputHandler
            userInputHandler) {
        super(numberOfRows, numberOfColumns, validInputs, cellInfoList, userInputHandler);
        this.regions = true;
    }

    @Override
    public void drawGUI() {
        this.setLayout(new GridLayout(0, this.numberOfColumns));
        for (CellInfo cellInfo : this.cellInfoList) {
            this.add(new InshiNoHeyaCellView(cellInfo, validInputs, userInputHandler));
        }
        addClues();
        drawRegionBorders();
    }

    private void addClues() {
        Map<Integer,String> clueMap;
        clueMap = getClues();
        for (Map.Entry<Integer,String> entry : clueMap.entrySet()) {
            getCellById(entry.getKey() - 1).addClue(entry.getValue());
        }
    }

    private InshiNoHeyaCellView getCellById(int id) {
        Component cell = this.getComponent(id);
        return ((InshiNoHeyaCellView) cell);
    }

    private Map<Integer,String> getClues() {
        Map<Integer,String> clues = new HashMap<>();
        clues.put(1,"6");
        clues.put(2,"4");
        clues.put(4,"5");
        clues.put(5,"40");
        clues.put(7,"3");
        clues.put(9,"4");
        clues.put(11,"15");
        clues.put(13,"40");
        clues.put(16,"4");
        clues.put(17,"10");
        clues.put(19,"6");
        clues.put(24,"3");
        return clues;
    }

    private void drawRegionBorders() {
        drawBordersFirstRow();
        drawBordersSecondRow();
        drawBordersThreeRow();
        drawBordersFourthRow();
        drawBordersFifthRow();
    }

    private void drawBordersFifthRow() {
        getCellById(20).setBorder(BorderFactory.createMatteBorder(1,2,2,2,Color.black));
        getCellById(21).setBorder(BorderFactory.createMatteBorder(1,2,2,2,Color.black));
        getCellById(22).setBorder(BorderFactory.createMatteBorder(1,2,2,2,Color.black));
        getCellById(23).setBorder(BorderFactory.createMatteBorder(2,2,2,1,Color.black));
        getCellById(24).setBorder(BorderFactory.createMatteBorder(2,1,2,2,Color.black));
    }

    private void drawBordersFourthRow() {
        getCellById(15).setBorder(BorderFactory.createMatteBorder(2,2,1,2,Color.black));
        getCellById(16).setBorder(BorderFactory.createMatteBorder(2,2,1,1,Color.black));
        getCellById(17).setBorder(BorderFactory.createMatteBorder(1,2,1,2,Color.black));
        getCellById(18).setBorder(BorderFactory.createMatteBorder(2,2,2,1,Color.black));
        getCellById(19).setBorder(BorderFactory.createMatteBorder(2,1,2,2,Color.black));
    }

    private void drawBordersThreeRow() {
        getCellById(10).setBorder(BorderFactory.createMatteBorder(2,2,2,1,Color.black));
        getCellById(11).setBorder(BorderFactory.createMatteBorder(2,1,2,2,Color.black));
        getCellById(12).setBorder(BorderFactory.createMatteBorder(2,2,1,2,Color.black));
        getCellById(13).setBorder(BorderFactory.createMatteBorder(1,2,2,2,Color.black));
        getCellById(14).setBorder(BorderFactory.createMatteBorder(1,2,2,2,Color.black));
    }

    private void drawBordersSecondRow() {
        getCellById(5).setBorder(BorderFactory.createMatteBorder(1,2,2,2,Color.black));
        getCellById(6).setBorder(BorderFactory.createMatteBorder(2,2,2,1,Color.black));
        getCellById(7).setBorder(BorderFactory.createMatteBorder(2,1,2,2,Color.black));
        getCellById(8).setBorder(BorderFactory.createMatteBorder(2,2,1,2,Color.black));
        getCellById(9).setBorder(BorderFactory.createMatteBorder(1,2,1,2,Color.black));
    }

    private void drawBordersFirstRow() {
        getCellById(0).setBorder(BorderFactory.createMatteBorder(2,2,1,2,Color.black));
        getCellById(1).setBorder(BorderFactory.createMatteBorder(2,2,2,1,Color.black));
        getCellById(2).setBorder(BorderFactory.createMatteBorder(2,1,2,2,Color.black));
        getCellById(3).setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.BLACK));
        getCellById(4).setBorder(BorderFactory.createMatteBorder(2,2,1,2,Color.black));
    }
}


