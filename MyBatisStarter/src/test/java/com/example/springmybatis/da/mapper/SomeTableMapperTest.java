package com.example.springmybatis.da.mapper;

import com.example.springmybatis.da.query.SomeTableSelectQuery;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SomeTableMapperTest {

    @Autowired
    private SomeTableMapper someTableMapper;

    @Test
    void select() {
        // TODO ハンズオン 7-3 テストを実行する
        var query = new SomeTableSelectQuery();
        query.setStringBoolean(true);
        var list = someTableMapper.select(query);

        assertEquals(1, list.size());

        var someTable = list.get(0);

        assertEquals(4, someTable.getStringList().size());

    }
}
