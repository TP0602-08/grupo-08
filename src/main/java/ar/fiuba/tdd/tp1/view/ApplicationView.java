package ar.fiuba.tdd.tp1.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;


public class ApplicationView extends JFrame {

    public ApplicationView() {
        super("GameEngine - Group8");
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);

        JTextField filePathTextField = new JTextField(40);
        TitledBorder titledBorder = new TitledBorder("Write path to configuration file");
        filePathTextField.setBorder(titledBorder);
        this.add(filePathTextField);
        JButton createGameButton = new JButton("create game");
        this.add(createGameButton);
        this.setVisible(true);
    }
}
