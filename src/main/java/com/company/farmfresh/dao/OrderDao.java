package com.company.farmfresh.dao;

import com.company.farmfresh.model.Order;

import java.util.List;

public interface OrderDao {
    List<Order> listOfOrders();

    void addOrder(Order order);

    Order findById(int id);
}
