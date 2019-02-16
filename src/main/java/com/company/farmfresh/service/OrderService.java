package com.company.farmfresh.service;

import com.company.farmfresh.model.Order;

import java.util.List;

public interface OrderService {
    void addOrder(Order order);
    Order findById(int id);
    List<Order> listOfOrders();

}
