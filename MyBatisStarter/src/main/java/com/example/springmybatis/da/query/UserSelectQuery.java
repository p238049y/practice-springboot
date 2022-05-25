package com.example.springmybatis.da.query;

import lombok.Data;

import java.util.List;

@Data
public class UserSelectQuery {
    private List<Integer> ids;
    private String userName;
    private String email;
    private String memo;
}
