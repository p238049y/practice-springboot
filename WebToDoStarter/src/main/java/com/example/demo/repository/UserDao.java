package com.example.demo.repository;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    List<User> findActiveUsers();

    User findById(int id);

    int insert(User user);

    int update(User user);

    int deleteById(int id);
}
