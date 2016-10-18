package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.controller.DeleteButtonController;
import ar.fiuba.tdd.tp1.controller.InputButtonController;
import ar.fiuba.tdd.tp1.controller.UserInputHandler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

public class GameInputView extends JDialog {

    public GameInputView(int posX, int posY) {
        super();
        this.setTitle("Select value");
        this.setBounds(posX, posY, 300, 100);
        this.setLayout(new FlowLayout());
    }

    public void generateInputButtons(int cellId, List<String> validInputs, UserInputHandler userInputHandler) {

        for (String validInput : validInputs) {
            this.add(new InputGameButton(validInput,new InputButtonController(cellId,userInputHandler,this)));
        }

        this.add(new InputDeleteButton("Delete", new DeleteButtonController(cellId,userInputHandler,this)));
    }


}
