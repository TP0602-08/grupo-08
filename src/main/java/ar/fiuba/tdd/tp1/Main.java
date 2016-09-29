package ar.fiuba.tdd.tp1;

import ar.fiuba.tdd.tp1.controller.ApplicationController;
import ar.fiuba.tdd.tp1.view.ApplicationView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationView applicationView = new ApplicationView();
        ApplicationController applicationController = new ApplicationController();
        applicationController.setView(applicationView);
        applicationController.run();
    }
}