package Controller;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import scene.sceneManager;

public class welcomePageController {
    public void btnWelcomepageOnAction(ActionEvent actionEvent) {
        sceneManager.switchPage("/view/LoginPage.fxml");
    }
}
