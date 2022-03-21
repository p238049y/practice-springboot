package com.example.demo.service;

import com.example.demo.dao.InquiryDao;
import com.example.demo.entity.Inquiry;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InquiryServiceImpl implements InquiryService{
    private final InquiryDao dao;

    @Autowired
    InquiryServiceImpl(InquiryDao dao) {
        this.dao = dao;
    }

    public void save(Inquiry inquiry){
        dao.insertInquiry(inquiry);
    }

    public List <Inquiry> getAll(){
        return dao.getAll();
    }
}
