package com.company.farmfresh.service;

import com.company.farmfresh.dao.OrderDao;
import com.company.farmfresh.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> listOfOrders() {
        return orderDao.listOfOrders();
    }

    @Override
    public void addOrder(Order order) {
        orderDao.addOrder(order);
    }

    @Override
    public Order findById(int id) {
        return orderDao.findById(id);
    }
}
