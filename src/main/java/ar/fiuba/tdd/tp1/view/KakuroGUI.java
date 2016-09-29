package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.model.Game;

import java.awt.*;

public class KakuroGUI extends GameGUI {

    private Game gameModel;

    public KakuroGUI(Game gameModel) {
        super();
        this.drawBorder();
        this.gameModel = gameModel;
    }

    public void drawGUI(int rows, int columns, int subRegions) {
        this.setLayout(new GridLayout(0, columns));
        this.fillBoard();
    }

    private void fillBoard() {
        this.add(new KakuroCellView(gameModel.getCell(1).datumToString(), false));
        this.add(new KakuroCellView("1\\", false));
        this.add(new KakuroCellView("2\\", false));
        this.add(new KakuroCellView("2\\3", false));
        this.add(new KakuroCellView("", true));
        this.add(new KakuroCellView("", true));
        this.add(new KakuroCellView("", true));
        this.add(new KakuroCellView("5\\7", false));
        this.add(new KakuroCellView("", true));
        this.add(new KakuroCellView("\\7", false));
        this.add(new KakuroCellView("", true));
        this.add(new KakuroCellView("", true));
        this.add(new KakuroCellView("", true));
        this.add(new KakuroCellView("4\\8", false));
        this.add(new KakuroCellView("", true));


    }

}






