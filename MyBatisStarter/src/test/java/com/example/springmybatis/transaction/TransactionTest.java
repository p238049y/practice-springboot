package com.example.springmybatis.transaction;

import com.example.springmybatis.da.entity.User;
import com.example.springmybatis.da.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TransactionTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TransactionTestService transactionTestService;

    @Test
    void test1_1() {
        // TODO ハンズオン 6-1 テストを実行
        var newUsers = new ArrayList<User>();

        var validUser = new User();
        validUser.setUserName("User 3");
        validUser.setEmail("user3@example.com");
        validUser.setCreated(LocalDateTime.now());

        newUsers.add(validUser);

        var invalidUser = new User();
        newUsers.add(invalidUser);
        try {
            // このサービスでは引数で渡したUserエンティティをDBに登録します
            // 2件のレコードを渡しますが、2件目でエラーとなり、例外がスローされます
            transactionTestService.rollbackTest(newUsers);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 例外がスローされれば、トランザクションがロールバックしているはずなので、
        // レコード件数は初期に登録された2件のままとなるはずです
        var count = userMapper.count();

        assertEquals(2, count);
    }

    @Test
    void test1_2() {
        // TODO ハンズオン 6-2 テストを実行
        var newUsers = new ArrayList<User>();
        for (int i = 0; i < 11; i++) {
            var user = new User();
            var userKey = "A" + i;
            user.setUserName("User " + userKey);
            user.setEmail("user" + userKey + "@example.com");
            user.setCreated(LocalDateTime.now());

            newUsers.add(user);
        }

        try {
            // このサービスでは、10件を超えるUserエンティティを渡した場合、
            // 10件分のみ登録し、その後ToManyUsersExceptionをスローします。
            // ToManyUsersExceptionは@TransactionalのnoRollbackForに指定されていますので、
            // トランザクションは正常にコミットされます
            transactionTestService.rollbackTest(newUsers);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // トランザクションがコミットされているはずなので、
        // レコード件数は12件のままとなるはずです
        var count = userMapper.count();

        assertEquals(12, count);
    }

    private User createUpdateUser1() {
        var user = new User();
        user.setId(1);
        user.setUserName("NEW USER NAME");
        user.setEmail("new-user1@example.com");
        return user;
    }
}
