package dao;

import entity.Order;

public interface OrderDAO {

    void updateOrder(Order order);

    Order getOrderById(int id);
}