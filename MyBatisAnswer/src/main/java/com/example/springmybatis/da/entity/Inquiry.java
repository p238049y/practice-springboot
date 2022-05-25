package com.example.springmybatis.da.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 問合せ
 */
@Data
public class Inquiry {
    /**
     * ID
     */
    private int id;
    /**
     * 送信ユーザーID
     * inquiryテーブルでは user_id
     */
    private int sendUserId;
    /**
     * 内容
     */
    private String contents;
    /**
     * 無効
     */
    private boolean invalid;
    /**
     * 作成日時
     */
    private LocalDateTime created;
}
