package com.example.springmybatis.da.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import com.example.springmybatis.da.entity.InquiryTag;

@Repository
@Mapper
public interface AnInquiryTagMapper {

    // TODO ハンズオン 8-1-1 find用のアノテーションを定義
    @Select({"SELECT",
            "id, inquiry_id, description, created",
            " FROM",
            " inquiry_tag",
            " WHERE",
            " id = #{id}"})
    InquiryTag find(int id);

    // TODO ハンズオン 8-1-2 insert用のアノテーションを定義
    @Insert({"INSERT INTO inquiry_tag(inquiry_id, description, created)",
            "    VALUES (#{inquiryId}, #{description}, #{created})"})
    @Options(keyProperty = "id", useGeneratedKeys = true)
    void insert(InquiryTag inquiryTag);

    // TODO ハンズオン 8-1-3 update用のアノテーションを定義
    @Update({"<script>",
            "UPDATE inquiry_tag",
            "        <set>",
            "            inquiry_id = #{inquiryId},",
            "            description = #{description},",
            "            created = #{created}",
            "        </set>",
            "        WHERE id = #{id}",
            "</script>"})
    void update(InquiryTag inquiryTag);

    // TODO ハンズオン 8-1-4 delete用のアノテーションを定義
    @Delete({"DELETE FROM inquiry_tag",
            "        WHERE id = #{id}"})
	void delete(int id);

}
