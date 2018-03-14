package com.demo.springbootmybatis.service;

import com.github.pagehelper.PageHelper;
import com.demo.springbootmybatis.dao.domain.Acct;
import com.demo.springbootmybatis.dao.mapper.AcctMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class TestService {
    @Autowired
    AcctMapper acctMapper;

    /**
     * select by th.mybatis
     */
    public String getOne() {
        Acct acctSelection = new Acct();
        acctSelection.setAcctNo("170010001144148734");
        List<Acct> acct = acctMapper.select(acctSelection);
        acct.forEach(value -> System.out.println(value.getAcctAlias()));
        return acct.get(0).getAcctAlias();
    }

    /**
     * select by PageHelper
     *
     * @param pageNum  start with 0/1
     */
    @Transactional
    public List<Acct> getAcctListByAcctNoPagination(int pageNum, int pageSize, String acctNo) {
        PageHelper.startPage(pageNum, pageSize);
//        acctNo = null;//会改变sql结构，把select*改成select count(*)
        List<Acct> acct = acctMapper.likeAcctNo(acctNo);

        return acct;
    }

    /**
     * select by example
     */
    public List<Acct> getByExample(int pageNum, int pageSize, String acctNo) {
        Example example = new Example(Acct.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("acct_no", "%" + acctNo + "%");
        criteria.andEqualTo("acct_no", acctNo);
        List<Acct> acct = acctMapper.selectByExample(example);
        return acct;
    }

}
