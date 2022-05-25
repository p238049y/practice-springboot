package com.example.springmybatis.da.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 問合せタグ + 問合せ
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class InquiryTagView extends InquiryTag {
    /**
     * 問合せ
     */
    private Inquiry inquiry;
}
