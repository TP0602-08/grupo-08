package ar.fiuba.tdd.tp1.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;


public class GameButtonWindow extends JPanel {

    public GameButtonWindow() {
        super();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JButton solve = new JButton("solve");
        JButton clue = new JButton("clue");
        this.add(solve);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        this.add(clue);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        JLabel lab = new JLabel("  invalid move      ");
        lab.setHorizontalAlignment(JLabel.CENTER);
        TitledBorder titled = new TitledBorder("Move info");
        lab.setBorder(titled);
        this.add(lab);
    }
}
