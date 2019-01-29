package com.company.farmfresh.dao;

import com.company.farmfresh.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void addOrder(Order order) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        session.close();
    }
}
