package com.demo;

import com.demo.springbootmybatis.AcctsettleApplication;
import com.demo.springbootmybatis.dao.domain.Acct;
import com.demo.springbootmybatis.dao.mapper.AcctMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AcctsettleApplication.class)
@ActiveProfiles("dev")
public class AcctsettleApplicationTests {

	@Autowired
	AcctMapper acctMapper;

	@Test
	public void selectOne() {
		Acct acctSelection = new Acct();
		acctSelection.setAcctNo("170010001144148734");
		List<Acct> acct = acctMapper.select(acctSelection);
		acct.forEach(value -> System.out.println(value.getAcctAlias()));

	}
}