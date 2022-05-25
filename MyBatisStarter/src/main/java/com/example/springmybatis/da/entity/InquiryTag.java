package com.example.springmybatis.da.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 問合せタグ(inquiry_tag)
 */
@Data
public class InquiryTag {
    /**
     * ID
     */
    private int id;
    /**
     * 問合せID
     */
    private int inquiryId;
    /**
     * 記述(タグ名)
     */
    private String description;
    /**
     * 作成日時
     */
    private LocalDateTime created;
}
