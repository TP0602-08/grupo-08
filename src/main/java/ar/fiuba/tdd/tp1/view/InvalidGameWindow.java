package ar.fiuba.tdd.tp1.view;


import java.awt.*;
import javax.swing.*;

public class InvalidGameWindow extends JOptionPane {

    public InvalidGameWindow() {
        super();
        showMessageDialog(null, "Invalid game name","Error",JOptionPane.INFORMATION_MESSAGE);
    }
}
