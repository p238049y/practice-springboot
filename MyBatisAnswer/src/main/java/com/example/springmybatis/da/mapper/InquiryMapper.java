package com.example.springmybatis.da.mapper;

import com.example.springmybatis.da.entity.Inquiry;
import com.example.springmybatis.da.entity.InquiryView;
import com.example.springmybatis.da.query.InquiryViewSelectQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Mapper
public interface InquiryMapper {
    Optional<Inquiry> find(int id);

    List<InquiryView> selectView(InquiryViewSelectQuery query);
    List<InquiryView> selectView(InquiryViewSelectQuery query, RowBounds rowBounds);

    List<InquiryView> selectView2(InquiryViewSelectQuery query);
    List<InquiryView> selectView2(InquiryViewSelectQuery query, RowBounds rowBounds);
}
