package org.example;

import javafx.application.Application;
import javafx.stage.Stage;
import scene.sceneManager;

public class starter extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        sceneManager.setStage(stage);
        sceneManager.switchPage("/view/Welcomepage.fxml");
    }
}
