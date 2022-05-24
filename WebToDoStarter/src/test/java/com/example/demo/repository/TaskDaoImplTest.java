package com.example.demo.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@SpringBootTest
@ActiveProfiles("unit")
@Sql
class TaskDaoImplTest {
    @Autowired
    private TaskDaoImpl taskDao;

//    @Test
//    @DisplayName("findAllのテスト")
//    void findAll() {
//        var list = taskDao.findAll();
//
//        // 件数のチェック
//        Assertions.assertEquals(2, list.size());
//
//        // ２件目のレコードの取得
//        var task2 = list.get(2);
//        Assertions.assertNotNull(task2);
//    }
    @Test
    void findAllのテスト() {
        var list = taskDao.findAll();

        // 件数のチェック
        Assertions.assertEquals(2, list.size());

        // ２件目のレコードの取得
        var task2 = list.get(1);
        Assertions.assertNotNull(task2);

        // 各カラムの値が正しくセットされているか
        Assertions.assertEquals("サービスの自作", task2.getTitle());
        Assertions.assertEquals("マイクロサービスを作ってみる", task2.getDetail());
    }
}
