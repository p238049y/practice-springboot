package com.example.springmybatis.da.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * 問合せ + 問い合せタグ + 問合せメッセージ
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class InquiryViewN extends Inquiry {
    /**
     * 問合せタグ一覧
     */
    private List<InquiryTag> tags;
    /**
     * 問合せメッセージ一覧
     */
    private List<InquiryMessage> messages;
}
