package com.example.demo.repository;

import com.example.demo.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("findByIdのテスト(正常系)")
    void findById_1() {
        var user1 = userDao.findById(1);
        Assertions.assertNotNull(user1);

        Assertions.assertEquals("ユーザー1", user1.getUsername());
        Assertions.assertEquals("user1@example.com", user1.getEmail());
        Assertions.assertEquals("pass1", user1.getPassword());
        Assertions.assertTrue(user1.isEnabled());
        Assertions.assertEquals("USER", user1.getAuthorityId());
        Assertions.assertEquals("key1", user1.getTempKey());
    }

    @Test
    @DisplayName("findByIdのテスト(レコードが取得できない場合)")
    void findById_2() {
        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> userDao.findById(0));
    }

    @Test
    @DisplayName("insertのテスト(正常系)")
    void insert_1() {
        var user = new User();
        user.setUsername("ユーザーX");
        user.setEmail("userx@example.com");
        user.setPassword("passx");
        user.setEnabled(true);
        user.setAuthorityId("USER");
        user.setTempKey("keyx");

        var insertCount = userDao.insert(user);

        Assertions.assertEquals(1, insertCount);

        // 件数チェック
        var list = userDao.findAll();

        Assertions.assertEquals(5, list.size());

        //　登録されたレコードの取得
        var userX = list.get(4);

        Assertions.assertEquals(user.getUsername(), userX.getUsername());
        Assertions.assertEquals(user.getEmail(), userX.getEmail());
        Assertions.assertEquals(user.getPassword(), userX.getPassword());
        Assertions.assertEquals(user.isEnabled(), userX.isEnabled());
        Assertions.assertEquals(user.getAuthorityId(), userX.getAuthorityId());
        Assertions.assertEquals(user.getTempKey(), userX.getTempKey());
    }

    @Test
    @DisplayName("updateのテスト(正常系)")
    void update_1() {
        var user = new User();
        user.setId(2);
        user.setUsername("ユーザー2(NEW)");
        user.setEmail("user2-new@example.com");
        user.setPassword("pass2_new");
        user.setEnabled(false);
        user.setAuthorityId("ADMIN");
        user.setTempKey("key2_new");

        var updateCount = userDao.update(user);

        Assertions.assertEquals(1, updateCount);

        var user2 = userDao.findById(2);

        // レコードの存在チェック
        Assertions.assertNotNull(user2);

        // 各カラムの値が正しくセットされているか(この書き方は良くない)
        // Assertions.assertEquals(user, user2);

        // 各カラムの値が正しくセットされているか
        assertEquals(user.getUsername(), user2.getUsername());
        assertEquals(user.getEmail(), user2.getEmail());
        assertEquals(user.getPassword(), user2.getPassword());
        assertEquals(user.isEnabled(), user2.isEnabled());
        assertEquals(user.getAuthorityId(), user2.getAuthorityId());
        assertEquals(user.getTempKey(), user2.getTempKey());
    }

    @Test
    @DisplayName("updateのテスト(更新対象がない場合)")
    void update_2() {
        var user = new User();
        user.setId(10);
        var updateCount = userDao.update(user);
        Assertions.assertEquals(0, updateCount);
    }

    @Test
    @DisplayName("deleteByIdのテスト(正常系)")
    void deleteById_1() {

        // ユーザー情報が削除できたか？
        var deleteCount = userDao.deleteById(1);
        Assertions.assertEquals(1, deleteCount);

        var list = userDao.findAll();
        Assertions.assertEquals(3, list.size());

        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> userDao.findById(1));
    }

    @Test
    @DisplayName("deleteByIdのテスト(更新対象がない場合)")
    void deleteById_2() {
        // ユーザー情報が削除できたか？
        var deleteCount = userDao.deleteById(10);
        Assertions.assertEquals(0, deleteCount);

        var list = userDao.findAll();
        Assertions.assertEquals(4, list.size());
    }
}
