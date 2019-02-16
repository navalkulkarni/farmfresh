package com.company.farmfresh.service;

import com.company.farmfresh.dao.OrderDao;
import com.company.farmfresh.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public void addOrder(Order order) {
        orderDao.addOrder(order);
    }
}
