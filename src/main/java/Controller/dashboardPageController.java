package Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import scene.sceneManager;

public class dashboardPageController {
    public Button btnCategoryManu;
    public Button btnOrders;
    public Button btnShoppingCart;
    public Button btnItemManagement;
    public Button btnChickenCategory;
    public Button btnFishCategory;
    public Button btnComboCategory;
    public Button btnDrinkCategory;
    public Button btnHistory;
    public Button btnAnalysis;
    public Button btnLogout;

    public void btnCategoryManuOnAction(ActionEvent actionEvent) {
    }

    public void btnOrdersOnAction(ActionEvent actionEvent) {
    }

    public void btnShoppingCartOnAction(ActionEvent actionEvent) {
    }

    public void btnItemManagementOnAction(ActionEvent actionEvent) {
    }

    public void btnChickenCategoryOnAction(ActionEvent actionEvent) {
    }

    public void btnFishCategoryOnAction(ActionEvent actionEvent) {
    }

    public void btnComboCategoryOnAction(ActionEvent actionEvent) {
    }

    public void btnDrinkCategoryOnAction(ActionEvent actionEvent) {
    }

    public void btnHistoryOnAction(ActionEvent actionEvent) {
    }

    public void btnAnalysisOnAction(ActionEvent actionEvent) {
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) {
        sceneManager.switchPage("/view/LoginPage.fxml");
    }
}
