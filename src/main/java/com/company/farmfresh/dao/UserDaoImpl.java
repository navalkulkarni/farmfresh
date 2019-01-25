package com.company.farmfresh.dao;

import com.company.farmfresh.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User u) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(u);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public User findByEmail(String e) {
        Session session=sessionFactory.openSession();
        User u=session.get(User.class,e);
        session.close();
        return u;
    }

    @Override
    public void removeUser(User u) {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.delete(u);
        session.getTransaction().commit();
        session.close();
    }


}
