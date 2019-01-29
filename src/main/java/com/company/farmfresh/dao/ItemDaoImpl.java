package com.company.farmfresh.dao;

import com.company.farmfresh.model.Item;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class ItemDaoImpl implements ItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Item> listOfItems() {
        Session session =sessionFactory.openSession();


        // Execute query
        List<Item> items = session.createQuery("from Items").getResultList();

        session.close();

        return items;
    }

    @Override
    public void addItem(Item item) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteItem(Item item) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.delete(item);
        session.getTransaction().commit();
        session.close();
    }


    @Override
    public Item findById(int id) {
        Session session =sessionFactory.openSession();
        Item item=session.get(Item.class,id);
        session.close();
        return item;
    }


    @java.lang.Override
    public void updateItem(Item item) {
    Session session=sessionFactory.openSession();
    session.beginTransaction();
    session.saveOrUpdate(item);
    session.getTransaction().commit();
    session.close();
    }
}
