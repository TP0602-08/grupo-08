package ar.fiuba.tdd.tp1.controller;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

public class DeleteButtonController extends MouseInputAdapter{

    @Override
    public void mouseClicked(MouseEvent event) {
        System.out.println("delete button pressed");
    }
}
