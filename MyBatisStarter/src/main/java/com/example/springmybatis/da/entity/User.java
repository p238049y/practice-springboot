package com.example.springmybatis.da.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * ユーザー
 */
@Data
public class User {
    /**
     * ID
     */
    private int id;
    /**
     * ユーザー名
     */
    private String userName;
    /**
     * Eメールアドレス
     */
    private String email;

    /**
     * 作成日時
     */
    private LocalDateTime created;

    /**
     * メモ
     */
    private String memo;
}
