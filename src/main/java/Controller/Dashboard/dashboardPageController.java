package Controller.Dashboard;

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
        sceneManager.switchPage("/view/catalogPage.fxml");
    }

    public void btnOrdersOnAction(ActionEvent actionEvent) {
        sceneManager.switchPage("/view/orderPage.fxml");
    }

    public void btnShoppingCartOnAction(ActionEvent actionEvent) {
        sceneManager.switchPage("/view/shoppingCartPage.fxml");
    }

    public void btnItemManagementOnAction(ActionEvent actionEvent) {
        sceneManager.switchPage("/view/itemManagementPage.fxml");
    }

    public void btnChickenCategoryOnAction(ActionEvent actionEvent) {
        sceneManager.switchPage("/view/Catalogs/chickenCatalogPage.fxml");
    }

    public void btnFishCategoryOnAction(ActionEvent actionEvent) {
        sceneManager.switchPage("/view/Catalogs/fishCatalogPage.fxml");
    }

    public void btnComboCategoryOnAction(ActionEvent actionEvent) {
        sceneManager.switchPage("/view/Catalogs/comboPackCatalogPage.fxml");
    }

    public void btnDrinkCategoryOnAction(ActionEvent actionEvent) {
        sceneManager.switchPage("/view/Catalogs/beveragesCatalogPage.fxml");
    }

    public void btnHistoryOnAction(ActionEvent actionEvent) {
        sceneManager.switchPage("/view/");
    }

    public void btnAnalysisOnAction(ActionEvent actionEvent) {
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) {
        sceneManager.switchPage("/view/LoginPage.fxml");
    }
}
