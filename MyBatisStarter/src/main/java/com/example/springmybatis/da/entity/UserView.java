package com.example.springmybatis.da.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * ユーザー
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserView extends User {
    /**
     * 問合せ一覧
     */
    private List<Inquiry> inquiries;
}
