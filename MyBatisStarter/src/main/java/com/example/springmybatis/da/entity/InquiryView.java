package com.example.springmybatis.da.entity;

import lombok.*;
import java.util.List;

/**
 * 問合せ + ユーザー
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class InquiryView extends Inquiry {
    /**
     * ユーザー
     */
    private User user;
}
