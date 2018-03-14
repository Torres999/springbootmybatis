package com.demo.springbootmybatis.dao.mapper;

import com.demo.springbootmybatis.dao.MyMapper;
import com.demo.springbootmybatis.dao.domain.Acct;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AcctMapper extends MyMapper<Acct> {

    @Select("SELECT * FROM acct WHERE acct_no LIKE CONCAT('%',#{acctNo},'%')")
    List<Acct> likeAcctNo(String acctNo);
}