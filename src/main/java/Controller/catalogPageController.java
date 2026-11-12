package Controller;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import scene.sceneManager;

public class catalogPageController {
    public void btnFishBurgerOnAction(MouseEvent mouseEvent) {
        sceneManager.switchPage("/view/Catalogs/fishCatalogPage.fxml");
    }

    public void btnChickenBurgerOnAction(MouseEvent mouseEvent) {
        sceneManager.switchPage("/view/Catalogs/chickenCatalogPage.fxml");
    }

    public void btnComboBurgerOnAction(MouseEvent mouseEvent) {
        sceneManager.switchPage("/view/Catalogs/comboPackCatalogPage.fxml");
    }

    public void btnBevarageOnAction(MouseEvent mouseEvent) {
        sceneManager.switchPage("/view/Catalogs/beveragesCatalogPage.fxml");
    }

    public void btnBackToDashboardOnAction(ActionEvent actionEvent) {
        sceneManager.switchPage("/view/dashboardPage.fxml");
    }
}
