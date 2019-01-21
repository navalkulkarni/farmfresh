package com.company.farmfresh.dao;

import com.company.farmfresh.model.Item;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ItemDaoImpl implements ItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Item> listOfItems() {
        Session session =sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<Item> criteria = builder.createQuery(Item.class);

        // Specify criteria root
        criteria.from(Item.class);

        // Execute query
        List<Item> items = session.createQuery(criteria).getResultList();

        session.close();

        return items;
    }
}
