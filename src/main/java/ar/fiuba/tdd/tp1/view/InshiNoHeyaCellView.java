package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.controller.CellController;
import ar.fiuba.tdd.tp1.controller.UserInputHandler;
import ar.fiuba.tdd.tp1.model.CellInfo;

import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;

public class InshiNoHeyaCellView extends CellView {

    public InshiNoHeyaCellView(CellInfo cell, List<String> validInputs, UserInputHandler userInputHandler) {
        super();
        this.setPreferredSize(new Dimension(60,60));
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        this.setMargin(new Insets(0,0,0,0));
        CellController cellController = new CellController(cell.getId(),validInputs,userInputHandler,true);
        this.addMouseListener(cellController);
    }

    public void addClue(String value) {
        JPanel cluePanel = new JPanel(new BorderLayout());
        JLabel clue = new JLabel(value);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        clue.setFont(new Font("Serif",Font.BOLD,12));
        cluePanel.setBackground(Color.WHITE);
        cluePanel.add(clue, BorderLayout.WEST);
        this.add(cluePanel, BorderLayout.NORTH);

    }
}
