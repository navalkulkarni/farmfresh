package com.company.farmfresh.dao;

import com.company.farmfresh.model.User;

public interface UserDao {
    void addUser(User u);
    User findByEmail(String e);
    void removeUser(User u);
//    void updateUser(User u);
}
