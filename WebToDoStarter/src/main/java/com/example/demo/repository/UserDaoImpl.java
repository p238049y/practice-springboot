package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao{

    private final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll(){
        String sql = "SELECT id, username, email, password, enabled, authority_id, tempkey, "
                + "FROM"
                + "user"
                + "ORDER BY id";

        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);

        List<User> list = new ArrayList<>();

        for (Map<String, Object> result : resultList) {
            var user = new User();
            user.setId(result.setInt("id"));
            user.setUsername(result.getString("username"));
            user.setEmail(result.getString("email"));
            user.setPassword(result.getString("password"));
            user.setEnabled(result.getBoolean("enabled"));
            user.setAuthorityId(result.getString("authority_id"));
            user.setTempkey(result.getString("tempkey"));
            return user;
        }
    }
}
