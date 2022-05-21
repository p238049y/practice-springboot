package com.example.demo.repository;

import com.example.demo.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringJUnitConfig
@SpringBootTest
@ActiveProfiles("unit")
@Sql
class UserDaoImplTest {

    @Autowired
    private UserDaoImpl userDao;

    @Test
    @DisplayName("findAllのテスト")
    void findAll() {
        var list = userDao.findAll();

        // 件数チェック
        Assertions.assertEquals(4, list.size());

        // ２件目のレコードの取得
        var user2 = list.get(1);
        Assertions.assertNotNull(user2);

        // 各カラムの値が正しくセットされているか
        Assertions.assertEquals("ユーザー2", user2.getUsername());
        Assertions.assertEquals("user2@example.com", user2.getEmail());
        Assertions.assertEquals("pass2", user2.getPassword());
        Assertions.assertFalse(user2.isEnabled());
        Assertions.assertEquals("USER", user2.getAuthorityId());
        Assertions.assertEquals("key2", user2.getTempKey());
    }

    @Test
    @DisplayName("findActiveUsersのテスト")
    void findActiveUsers() {
        var list = userDao.findActiveUsers();

        Assertions.assertEquals(3, list.size());

        var user3 = list.get(2);
        Assertions.assertNotNull(user3);

        Assertions.assertTrue(list.stream().allMatch(User::isEnabled));
    }
}
