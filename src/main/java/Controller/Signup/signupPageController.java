package Controller.Signup;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import scene.sceneManager;

public class signupPageController {
    public TextField txtfullname;
    public TextField txtusername;
    public TextField txtpassword;
    public TextField txtrole;
    public Button btnSignup;

    signupController signupController = new signupController();

    public void btnSignupOnAction(ActionEvent actionEvent) {
        signupController.signupAuthentication(txtfullname.getText(),txtusername.getText(),txtpassword.getText(),txtrole.getText());
    }

    public void btnloginOnAction(ActionEvent actionEvent) {
        sceneManager.switchPage("/view/LoginPage.fxml");
    }
}
