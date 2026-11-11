package Controller.login;

import db.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginController {

    Connection connection = DBconnection.getInstance().getConnection();

    public boolean loginAuthentication(String username, String password){
        String loginSql = "SELECT * FROM users";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(loginSql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String DBusername = resultSet.getNString("username");
                String DBpassword = resultSet.getNString("password");

                if (username.equals(DBusername) && password.equals(DBpassword)){
                    return true;
                }
            }
            return false;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
