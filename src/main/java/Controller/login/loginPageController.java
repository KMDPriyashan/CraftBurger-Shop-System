package Controller.login;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import scene.sceneManager;

public class loginPageController {
    public TextField txtusername;
    public TextField txtpassword;
    public Button btnlogin;
    public Button btnsignup;

    loginController loginController = new loginController();

    public void btnloginOnAction(ActionEvent actionEvent) {
        if (loginController.loginAuthentication(txtusername.getText(),txtpassword.getText())){
            sceneManager.switchPage("/view/dashboardPage.fxml");
        }
    }

    public void btnsignupOnAction(ActionEvent actionEvent) {
        sceneManager.switchPage("/view/signupPage.fxml");
    }
}
