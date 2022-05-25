package com.example.demo.repository;

import com.example.demo.entity.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringJUnitConfig
@SpringBootTest
@ActiveProfiles("unit")
@Sql
class TaskDaoImplTest {
    @Autowired
    private TaskDaoImpl taskDao;

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


    @Test
    void findByIdでレコードが取得できない場合(){
        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> taskDao.findById(10));
    }

    @Test
    void insertの正常系テスト(){
        var task = new Task();

        task.setUserId(1);
        task.setTypeId(3);
        task.setTitle("テストコードの作成");
        task.setDetail("書いてみよう");
        task.setDeadline(LocalDateTime.parse("2021-07-07 15:00:00"));

        taskDao.insert(task);

        var list = taskDao.findAll();

        Assertions.assertEquals(3, list.size());
    }

    @Test
    void deleteByIdのテスト() {
        taskDao.deleteById(1);
        var list = taskDao.findAll();

        Assertions.assertEquals(2, list.size());

        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> taskDao.findById(1));
    }

    @Test
    void deleteByIdの対象がない場合のテスト(){
        taskDao.deleteById(10);
        var list = taskDao.findAll();

        Assertions.assertEquals(2, list.size());
    }
}
