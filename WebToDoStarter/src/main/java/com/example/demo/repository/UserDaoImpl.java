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
            user.setId((int)result.get("id"));
            user.setUsername((String) result.get("username"));
            user.setEmail((String)result.get("email"));
            user.setPassword((String)result.get("password"));
            user.setEnabled((boolean) result.get("enabled"));
            user.setAuthorityId((String) result.get("authority_id"));
            user.setTempKey((String)result.get("tempkey"));

            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findActiveUsers() {
        String sql = "SELECT id, username, email, password, enabled, authority_id, tempKey,"
                + "FROM" + "user"
                + "WHERE enabled = 1"
                + "ORDER BY id";

        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);

        List<User> list = new ArrayList<>();

        resultList.forEach(result -> {
            var user = new User();
            user.setId((int)result.get("id"));
            user.setUsername((String) result.get("username"));
            user.setEmail((String)result.get("email"));
            user.setPassword((String)result.get("password"));
            user.setEnabled((boolean) result.get("enabled"));
            user.setAuthorityId((String) result.get("authority_id"));
            user.setTempKey((String)result.get("tempKey"));

            list.add(user);
        });

        return list;
    }
}
