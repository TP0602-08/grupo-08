package ar.fiuba.tdd.tp1.view;

import java.awt.*;

public class KakuroGUI extends GameGUI {

    public KakuroGUI() {
        super();
        this.drawBorder();
    }

    public void drawGUI(int rows, int columns, int subRegions) {
        this.setLayout(new GridLayout(0, columns));
        this.fillBoard();
    }

    private void fillBoard() {
        this.add(new KakuroCellView("", false));
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






