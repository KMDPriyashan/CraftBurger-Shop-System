package Controller.catalogs.Chicken;

import Model.Order;

import java.util.ArrayList;
import java.util.List;

public class chickenController {
    List<Order> orderList = new ArrayList<>();
    private int orderCount = 0;

    public String generateId(){
        orderCount++;
        return String.format("ORD-%04d",orderCount);
    }

    public void addBurgerTOCart(String burgerName, double price, String customerName){
        String id = generateId();
        Order order = new Order(id,burgerName,price,customerName);
        orderList.add(order);
        System.out.println(orderList);
    }

}
