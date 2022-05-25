package com.example.springmybatis.da.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 問合せメッセージ
 */
@Data
public class InquiryMessage {
    /**
     * ID
     */
    private int id;
    /**
     * 問合せID
     */
    private int inquiryId;
    /**
     * メッセージ
     */
    private String message;
    /**
     * 作成日時
     */
    private LocalDateTime created;
}
