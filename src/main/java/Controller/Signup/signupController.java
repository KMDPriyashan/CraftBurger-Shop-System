package Controller.Signup;

import db.DBconnection;
import scene.sceneManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class signupController {
    Connection connection = DBconnection.getInstance().getConnection();

    public void signupAuthentication(String fullName, String username, String password, String role){

        String signupSql = "INSERT INTO users (full_name, username, password, role) VALUES (?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(signupSql);
            preparedStatement.setString(1,fullName);
            preparedStatement.setString(2,username);
            preparedStatement.setString(3,password);
            preparedStatement.setString(4,role);

            int resultValue = preparedStatement.executeUpdate();
            if (resultValue > 0){
                sceneManager.switchPage("/view/LoginPage.fxml");
            }else {
                sceneManager.switchPage("/view/signupPage.fxml");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
