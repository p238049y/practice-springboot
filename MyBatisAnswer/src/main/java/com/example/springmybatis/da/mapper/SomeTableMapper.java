package com.example.springmybatis.da.mapper;

import com.example.springmybatis.da.entity.SomeTable;
import com.example.springmybatis.da.entity.User;
import com.example.springmybatis.da.query.SomeTableSelectQuery;
import com.example.springmybatis.da.query.UserSelectQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Mapper
public interface SomeTableMapper {
    List<SomeTable> select(SomeTableSelectQuery query);
}
