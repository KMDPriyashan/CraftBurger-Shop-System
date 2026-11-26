package Controller.catalogs.Chicken;

import Model.Order;
import db.DBconnection;
import scene.sceneManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class chickenController {

    Connection connection = DBconnection.getInstance().getConnection();
    private List<Object[]> tempCartArray = new ArrayList<>();  // temporary array
    private List<Order> orderList = new ArrayList<>();
    private int orderCount = 0;

    public String generateId(){
        orderCount++;
        return String.format("ORD-%04d",orderCount);
    }

    public void addBurgerTOCart(String burgerName, double price, String customerName) {
        String id = generateId();
        Order order = new Order(id, burgerName, price, customerName);
        orderList.add(order);
        tempCartArray.add(new Object[]{id, burgerName, price, customerName});
        saveCartToDatabase();
    }

    private void saveCartToDatabase() {
        String sql = "INSERT INTO cart (order_id, burger_name, price, customer_name) VALUES (?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            for (Object[] row : tempCartArray) {
                preparedStatement.setString(1, (String) row[0]);
                preparedStatement.setString(2, (String) row[1]);
                preparedStatement.setDouble(3, (Double) row[2]);  // FIX: use setDouble
                preparedStatement.setString(4, (String) row[3]);
                preparedStatement.addBatch();
            }

            int[] results = preparedStatement.executeBatch();

            if (results.length > 0) {
                sceneManager.switchPage("/view/catalogPage.fxml");
            } else {
                sceneManager.switchPage("/view/Catalogs/chickenCatalogPage.fxml");
            }

            tempCartArray.clear();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
