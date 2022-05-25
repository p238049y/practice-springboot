package com.example.springmybatis.da.query;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SomeTableSelectQuery {
    private LocalDate fromNumberDate;
    private LocalDate toNumberDate;
    private Integer stringInteger;
    private Boolean stringBoolean;
}
