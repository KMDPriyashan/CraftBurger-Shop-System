package Controller.catalogs.Chicken;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import scene.sceneManager;

public class chickenCatalogPageController {
    public Label lbl01Name;
    public Label lbl01Price;
    public Label lbl02Name;
    public Label lbl02Price;
    public TextField txtCustomerName;

    chickenController chickenController = new chickenController();

    public void btnhomePageOnAction(ActionEvent actionEvent) {
        sceneManager.switchPage("/view/dashboardPage.fxml");
    }

    public void btnFishOnAction(ActionEvent actionEvent) {
        sceneManager.switchPage("/view/Catalogs/fishCatalogPage.fxml");
    }

    public void btnBevarageOnAction(ActionEvent actionEvent) {
        sceneManager.switchPage("/view/Catalogs/beveragesCatalogPage.fxml");
    }

    public void btnComboOnAction(ActionEvent actionEvent) {
        sceneManager.switchPage("/view/Catalogs/comboPackCatalogPage.fxml");
    }

    public void btnChicken01OnAction(MouseEvent mouseEvent) {
        String burgerName = "Classic Beef Burger";
        double price = 820.50;
        chickenController.addBurgerTOCart(burgerName,price,txtCustomerName.getText());
    }

    public void btnChicken02OnAction(MouseEvent mouseEvent) {
        String burgerName = "Cheese Lover's Burger";
        double price = 1820.50;
        chickenController.addBurgerTOCart(burgerName,price,txtCustomerName.getText());
    }

    public void btnChicken03OnAction(MouseEvent mouseEvent) {
        String burgerName = "Spicy Chicken Burger";
        double price = 1025.50;
        chickenController.addBurgerTOCart(burgerName,price,txtCustomerName.getText());
    }

    public void btnChicken04OnAction(MouseEvent mouseEvent) {
        String burgerName = "BBQ Bacon Burger";
        double price = 620.50;
        chickenController.addBurgerTOCart(burgerName,price,txtCustomerName.getText());
    }

    public void btnChicken05OnAction(MouseEvent mouseEvent) {
        String burgerName = "Mushroom Swiss Burger";
        double price = 625.50;
        chickenController.addBurgerTOCart(burgerName,price,txtCustomerName.getText());
    }

    public void btnChicken06OnAction(MouseEvent mouseEvent) {
        String burgerName = "Double Patty Beef Burger";
        double price = 1200.50;
        chickenController.addBurgerTOCart(burgerName,price,txtCustomerName.getText());
    }

    public void btnChicken07OnAction(MouseEvent mouseEvent) {
        String burgerName = "Crispy Chicken Burger";
        double price = 1320.50;
        chickenController.addBurgerTOCart(burgerName,price,txtCustomerName.getText());
    }

    public void btnChicken08OnAction(MouseEvent mouseEvent) {
        String burgerName = "Veggie Delight Burger";
        double price = 1000.50;
        chickenController.addBurgerTOCart(burgerName,price,txtCustomerName.getText());
    }

    public void btnChicken09OnAction(MouseEvent mouseEvent) {
        String burgerName = "Fish Fillet Burger";
        double price = 1020.50;
        chickenController.addBurgerTOCart(burgerName,price,txtCustomerName.getText());
    }

    public void btnChicken10OnAction(MouseEvent mouseEvent) {
        String burgerName = "Egg & Cheese Burger";
        double price = 500.50;
        chickenController.addBurgerTOCart(burgerName,price,txtCustomerName.getText());
    }

    public void btnChicken11OnAction(MouseEvent mouseEvent) {
        String burgerName = "Hot & Spicy Beef Burger";
        double price = 1120.50;
        chickenController.addBurgerTOCart(burgerName,price,txtCustomerName.getText());
    }

    public void btnChicken12OnAction(MouseEvent mouseEvent) {
        String burgerName = "Ultimate Club Burger";
        double price = 1250.50;
        chickenController.addBurgerTOCart(burgerName,price,txtCustomerName.getText());
    }
}
