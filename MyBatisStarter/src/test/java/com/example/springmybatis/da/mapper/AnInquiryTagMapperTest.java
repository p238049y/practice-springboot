package com.example.springmybatis.da.mapper;

import com.example.springmybatis.da.entity.InquiryTag;
import com.example.springmybatis.da.query.InquiryTagSelectQuery;
import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static com.example.springmybatis.da.query.InquiryTagSelectQuery.OrderByField;
import static com.example.springmybatis.da.query.InquiryTagSelectQuery.SortOrder;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AnInquiryTagMapperTest {

    @Autowired
    private AnInquiryTagMapper inquiryTagMapper;

    @Test
    void test() {
        // TODO ハンズオン 8-2 テストを実行する

        // findのテスト
        var inquiryTag1 = inquiryTagMapper.find(1);

        assertNotNull(inquiryTag1);

        assertEquals("問合せ", inquiryTag1.getDescription());

        // insertのテスト
        var inquiryTag = new InquiryTag();
        inquiryTag.setInquiryId(1);
        inquiryTag.setDescription("保存");
        inquiryTag.setCreated(LocalDateTime.now());

        inquiryTagMapper.insert(inquiryTag);

        assertEquals(8, inquiryTag.getId());

        // updateのテスト
        inquiryTag.setDescription("保管");

        inquiryTagMapper.update(inquiryTag);

        var updatedInquiryTag = inquiryTagMapper.find(8);

        assertNotNull(updatedInquiryTag);

        assertEquals(updatedInquiryTag.getDescription(), inquiryTag.getDescription());

        // deleteの削除

        inquiryTagMapper.delete(8);

        var deletedInquiryTag = inquiryTagMapper.find(8);

        assertNull(deletedInquiryTag);

    }
}
