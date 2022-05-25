package com.example.springmybatis.da.mapper;

import com.example.springmybatis.da.entity.InquiryTag;
import com.example.springmybatis.da.entity.InquiryTagView;
import com.example.springmybatis.da.query.InquiryTagSelectQuery;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AnInquiryTagMapper {

    // TODO ハンズオン 8-1-1 find用のアノテーションを定義
    @Select({
            "select id, inquiry_id, description, created",
            "from inquiry_tag",
            "where id = #{id}"})
    InquiryTag find(int id);

    // TODO ハンズオン 8-1-2 insert用のアノテーションを定義
    @Insert({"insert into inquiry_tag",
            "(inquiry_id, description, created)",
            "values (#{inquiryId}, #{description}, #{created})"})
    @Options(keyProperty = "id", useGeneratedKeys = true)
    void insert(InquiryTag inquiryTag);

    // TODO ハンズオン 8-1-3 update用のアノテーションを定義
    @Update({
            "<script>",
            "update inquiry_tag",
            "<set>",
            "inquiry_id = #{inquiryId},",
            "description = #{description},",
            "created = #{created},",
            "</set>",
            "where id = #{id}",
            "</script>"
    })
    void update(InquiryTag inquiryTag);

    // TODO ハンズオン 8-1-4 delete用のアノテーションを定義
    @Delete({
            "delete from inquiry_tag",
            "where id = #{id}",
    })
    void delete(int id);

}
