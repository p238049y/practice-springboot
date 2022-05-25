package com.example.springmybatis.da.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectAllView() {
        // TODO ハンズオン 5-5 コメントアウトを解除してテストを実行
        var list = userMapper.selectAllView();

        assertEquals(2, list.size());

        var userView = list.get(0);

        assertEquals("User 1", userView.getUserName());

        var inquiries = userView.getInquiries();

        assertEquals(2, inquiries.size());

        var inquiry = inquiries.get(0);

        assertEquals(3, inquiry.getId());
    }

    @Test
    public void selectAllView2() {
        // TODO ハンズオン 5-9 コメントアウトを解除してテストを実行
        var list = userMapper.selectAllView2();

        assertEquals(2, list.size());

        var userView = list.get(0);

        assertEquals("User 1", userView.getUserName());

        var inquiries = userView.getInquiries();

        assertEquals(2, inquiries.size());

        var inquiry = inquiries.get(0);

        assertEquals(3, inquiry.getId());
    }
}
