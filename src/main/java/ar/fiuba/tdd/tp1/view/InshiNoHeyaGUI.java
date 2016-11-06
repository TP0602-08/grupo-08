package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.controller.UserInputHandler;
import ar.fiuba.tdd.tp1.model.CellInfo;
import ar.fiuba.tdd.tp1.serialization.json.CellBorderJsonSerializer;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;
import javax.swing.border.MatteBorder;



public class InshiNoHeyaGUI extends GameGUI {

    public InshiNoHeyaGUI(int numberOfRows, int numberOfColumns, List<String> validInputs, List<CellInfo> cellInfoList, UserInputHandler
            userInputHandler) {
        super(numberOfRows, numberOfColumns, validInputs, cellInfoList, userInputHandler);
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

    @Override
    public void drawGUI() {
        for (CellInfo cellInfo : this.cellInfoList) {
            this.add(createNewCellView(cellInfo));
        }
        addClues();
        drawRegionBorders();
    }

    @Override
    protected CellView createNewCellView(CellInfo cellInfo) {
        return new InshiNoHeyaCellView(cellInfo,this.validInputs,this.userInputHandler);
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

    private void drawRegionBorders()  {
        CellBorderJsonSerializer cellBorderJsonSerializer = new CellBorderJsonSerializer("inshinoheya");
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




}


