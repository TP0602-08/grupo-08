package ar.fiuba.tdd.tp1.view;

import ar.fiuba.tdd.tp1.controller.ApplicationController;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;


public class ApplicationView extends JFrame {

    private JTextField configFilePathTextField;
    private JButton createGameButton;
    private JLabel imageLabel;
    private ApplicationController applicationController;

    public ApplicationView() {
        super("GameEngine - Group8");
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.imageLabel = new JLabel(new ImageIcon("src/main/resources/LogoFiuba.jpg"));
        this.add(imageLabel);

        this.configFilePathTextField = new JTextField(40);
        TitledBorder titledBorder = new TitledBorder("Write game name ");
        configFilePathTextField.setBorder(titledBorder);
        this.add(configFilePathTextField);
        this.createGameButton = new JButton("create game");
        this.add(createGameButton);
    }

    public void setVisible() {
        this.setVisible(true);
    }

    public void dismissView() {
        this.dispose();
    }

    public void setController(ApplicationController applicationController) {
        this.applicationController = applicationController;
        this.createGameButton.addMouseListener(this.applicationController);
    }

    public String getTextField() {
        return this.configFilePathTextField.getText();
    }
}
