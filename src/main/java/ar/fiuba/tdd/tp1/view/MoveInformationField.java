package ar.fiuba.tdd.tp1.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;


class MoveInformationField extends JTextField {

    MoveInformationField() {
        super(60);
        TitledBorder titledBorder = new TitledBorder("Move info ");
        this.setBorder(titledBorder);
    }
}
