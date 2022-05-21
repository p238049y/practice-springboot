package com.example.demo.repository;

import com.example.demo.entity.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    /**
     * アクティブユーザー一覧を取得
     * @return
     */
    List<User> findActiveUsers();

    User findById(int id);

    int insert(User user);

    int update(User user);

    int deleteById(int id);
}
