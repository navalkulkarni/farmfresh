package com.company.farmfresh.service;

import com.company.farmfresh.dao.UserDao;
import com.company.farmfresh.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public void addUser(User u) {
        userDao.addUser(u);
    }

    @Override
    public User findByEmail(String e) {
        User u=userDao.findByEmail(e);
        return u;
    }

    @Override
    public void removeUser(User u) {
        userDao.removeUser(u);
    }

    @Override
    public void updateUser(User u) {

        userDao.updateUser(u);
    }
}
