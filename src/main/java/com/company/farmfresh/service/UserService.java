package com.company.farmfresh.service;

import com.company.farmfresh.model.User;

public interface UserService {
    void addUser(User u);
    User findByEmail(String e);
    void removeUser(User u);
    void updateUser(User u);
//    void updateUser(User u);
}
