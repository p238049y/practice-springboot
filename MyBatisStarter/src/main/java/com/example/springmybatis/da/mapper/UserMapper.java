package com.example.springmybatis.da.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.example.springmybatis.da.entity.User;
import com.example.springmybatis.da.query.UserSelectQuery;

@Repository
@Mapper
public interface UserMapper {

    Optional<User> find(int id);

    Optional<User> findForUpdate(int id);

    void insert(User user);

    void batchInsert(@Param("users") List<User> users);

    void update(User user);

    void delete(int id);

    long count();

    List<User> selectByEmailAndInvalid(@Param("email") String email, @Param("memo") String memo);

    List<User> selectAll();

    List<User> selectAll(RowBounds rowBounds);

    List<User> select(UserSelectQuery query);

    List<User> select(UserSelectQuery query, RowBounds rowBounds);

    // TODO ハンズオン 5-1 selectAllViewメソッドを定義

    // TODO ハンズオン 5-6 selectAllView2メソッドを定義

}
