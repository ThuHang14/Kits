package org.example.dao;

import org.example.model.User;

public interface UserDao {
    public User getUserByEmailAndPassword(String user, String pass);
}
