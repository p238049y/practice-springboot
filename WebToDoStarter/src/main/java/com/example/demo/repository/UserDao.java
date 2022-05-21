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

    /**
     * IDから特定のユーザー情報を取得
     * @param id
     * @return
     */
    User findById(int id);

    /**
     * ユーザー情報を登録する
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * ユーザー情報を更新する
     * @param user
     * @return
     */
    int update(User user);

    /**
     * ユーザー情報を削除する
     * @param id
     * @return
     */
    int deleteById(int id);
}
