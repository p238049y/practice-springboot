package com.example.springmybatis.da.mapper;

import com.example.springmybatis.da.entity.User;
import com.example.springmybatis.da.query.UserSelectQuery;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Mapper
public interface AnUserMapper {

    @Select({
            "select",
            "id, user_name, email, created",
            "from user",
            "where id = #{id}"})
    @Results(id = "Base_Result_Map", value = {
            @Result(id = true, column = "id", property = "id", jdbcType = JdbcType.INTEGER),
            @Result(column = "user_name", property = "userName", jdbcType=JdbcType.VARCHAR),
    })
    Optional<User> find(int id);

    @Insert({"insert into user",
            "(user_name, email, created)",
            "values (#{user_name}, #{email}, #{created})"})
    @Options(keyProperty = "id", useGeneratedKeys = true)
    void insert(User user);

    @Update({
            "<script>",
            "update user",
            "<set>",
            "user_name = #{userId},",
            "email = #{email},",
            "created = #{createTs},",
            "</set>",
            "where id = #{id}",
            "</script>"
    })
    void update(User user);

    @Delete({
            "delete from user",
            "where id = #{id}",
    })
    void delete(int id);

    @Select({
            "select",
            "id, user_name, email, created",
            "from user",
            "order by id"})
    @ResultMap("Base_Result_Map")
    List<User> selectAll();
}
