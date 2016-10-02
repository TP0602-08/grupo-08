package ar.fiuba.tdd.tp1.view;

import javax.swing.*;

public class ConfigFileErrorWindow extends JOptionPane {

    public ConfigFileErrorWindow(String gameName) {
        super();
        String message = "An error ocurred when trying to deserialize " + gameName + " configuration files";
        showMessageDialog(null, message, "Configuration file error",JOptionPane.ERROR_MESSAGE);

    }

}
