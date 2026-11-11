package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static DBconnection instance;
    private static Connection connection;

    private DBconnection(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/craft_burger_db","root","");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DBconnection getInstance(){
        if(instance == null){
            instance = new DBconnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
