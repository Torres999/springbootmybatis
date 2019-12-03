package com.demo;

import com.demo.springbootmybatis.SpringbootMybatisApplication;
import com.demo.springbootmybatis.dao.domain.Acct;
import com.demo.springbootmybatis.dao.mapper.AcctMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisApplication.class)
@ActiveProfiles("dev")
@AutoConfigureMockMvc
public class SpringbootMybatisApplicationTests {

	@Autowired
	AcctMapper acctMapper;

	@Autowired
	private MockMvc mockMvc;


	@Test
	public void selectOne() {
		Acct acctSelection = new Acct();
		acctSelection.setAcctNo("170010001144148734");
		List<Acct> acct = acctMapper.select(acctSelection);
		acct.forEach(value -> System.out.println(value.getAcctAlias()));

	}

	@Test
	public void test() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/unitTest"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}