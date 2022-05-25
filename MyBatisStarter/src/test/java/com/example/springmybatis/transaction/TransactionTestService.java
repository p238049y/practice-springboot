package com.example.springmybatis.transaction;

import com.example.springmybatis.da.entity.User;
import com.example.springmybatis.da.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionTestService {

    private final UserMapper userMapper;

    public TransactionTestService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Transactional(noRollbackFor = ToManyUsersException.class)
    public void rollbackTest(List<User> users) {
        if (users == null) return;
        boolean toManyUsers = false;

        List<User> insertUsers = users;

        if (users.size() > 10) {
            insertUsers = users.subList(0, 10);
            toManyUsers = true;
        }

        insertUsers.forEach(userMapper::insert);

        if (toManyUsers) throw new ToManyUsersException();
    }
}
