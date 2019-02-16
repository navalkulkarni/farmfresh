package com.company.farmfresh.dao;

import com.company.farmfresh.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Order> listOfOrders() {
        Session session =sessionFactory.openSession();

        List<Order> orderList = session.createQuery("from Orders").getResultList();

        session.close();

        return orderList;
    }

    @Override
    public void addOrder(Order order) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Order findById(int id) {
        Session session =sessionFactory.openSession();
        Order order=session.get(Order.class,id);
        session.close();
        return order;
    }
}
