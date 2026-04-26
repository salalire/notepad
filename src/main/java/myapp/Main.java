package myapp;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.mainInterface;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        new mainInterface().show(stage);

    }
    public static void main(String[] args) {
        launch();
        }
    }
