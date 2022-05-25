package com.example.springmybatis.da.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.springmybatis.da.entity.InquiryTag;

@Repository
@Mapper
public interface AnInquiryTagMapper {

    // TODO ハンズオン 8-1-1 find用のアノテーションを定義
    InquiryTag find(int id);

    // TODO ハンズオン 8-1-2 insert用のアノテーションを定義
    void insert(InquiryTag inquiryTag);

    // TODO ハンズオン 8-1-3 update用のアノテーションを定義
    void update(InquiryTag inquiryTag);

    // TODO ハンズオン 8-1-4 delete用のアノテーションを定義
	void delete(int id);

}
