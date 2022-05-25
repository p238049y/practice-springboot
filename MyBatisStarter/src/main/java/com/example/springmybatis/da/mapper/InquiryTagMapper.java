package com.example.springmybatis.da.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.springmybatis.da.entity.InquiryTag;
import com.example.springmybatis.da.query.InquiryTagSelectQuery;

@Repository
@Mapper
public interface InquiryTagMapper {

    // TODO ハンズオン 1-1 findメソッドを定義

    // TODO ハンズオン 2-1 ページングができるようにメソッドの引数を変更する
    List<InquiryTag> select(InquiryTagSelectQuery query);

    // TODO ハンズオン 3-1-1 insertメソッドを定義

    // TODO ハンズオン 3-1-2 updateメソッドを定義

    // TODO ハンズオン 3-1-3 deleteメソッドを定義

     // TODO ハンズオン 4-1 findViewメソッドを定義

    // TODO ハンズオン 4-5 findView2メソッドを定義


}
