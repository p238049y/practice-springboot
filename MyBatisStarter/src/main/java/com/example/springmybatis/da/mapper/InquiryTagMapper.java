package com.example.springmybatis.da.mapper;

import java.util.List;

import com.example.springmybatis.da.entity.InquiryTagView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.example.springmybatis.da.entity.InquiryTag;
import com.example.springmybatis.da.query.InquiryTagSelectQuery;

@Repository
@Mapper
public interface InquiryTagMapper {

    // TODO ハンズオン 1-1 findメソッドを定義
    InquiryTag find(int id);

    // TODO ハンズオン 2-1 ページングができるようにメソッドの引数を変更する
    List<InquiryTag> select(InquiryTagSelectQuery query, RowBounds rowBounds);

    // TODO ハンズオン 3-1-1 insertメソッドを定義
    void insert(InquiryTag inquiryTag);

    // TODO ハンズオン 3-1-2 updateメソッドを定義
    void update(InquiryTag inquiryTag);

    // TODO ハンズオン 3-1-3 deleteメソッドを定義
    void delete(int id);

    // TODO ハンズオン 4-1 findViewメソッドを定義
    InquiryTagView findView(int id);

    // TODO ハンズオン 4-5 findView2メソッドを定義
    InquiryTagView findView2(int id);

}
