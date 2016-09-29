package ar.fiuba.tdd.tp1.controller;

import ar.fiuba.tdd.tp1.view.GameInputView;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

public class CellController extends MouseInputAdapter {
    @Override
    public void mouseClicked(MouseEvent event) {

        GameInputView gameInputView = new GameInputView(event.getXOnScreen(), event.getYOnScreen());
        gameInputView.generateInputButtons();
        gameInputView.setVisible(true);
    }
}

