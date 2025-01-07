package com.care.root;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import com.care.root.member.controller.MemberController;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:testMember.xml", 
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestMock {
	
	@Autowired MemberController mc;
	MockMvc mock;

	@Before //org.junit.before
	public void setUp() {
		System.out.println("--- setUp 실행 ---");
		mock = MockMvcBuilders.standaloneSetup(mc).build();
	}
	
	@Test
	public void testIndex() throws Exception {
		mock.perform(get("/index")) //get방식으로 index요청
		.andDo(print())//.찍고 기능추가 가능 / 접속한 결과값을 출력
		.andExpect(status().isOk())//통신했을때 결과가 200과 같냐
		.andExpect(forwardedUrl("member/index"));
	}
	
	@Test
	@Transactional(transactionManager = "txMgr")
	public void testInsert() throws Exception {
		mock.perform(post("/insert").param("id", "7878").param("name", "7878"))
		.andDo(print())
		.andExpect(status().is3xxRedirection()); //redirect는 is3xxx로 확인
	}
	
	@Test
	public void testMemberView() throws Exception{
		mock.perform(get("/memberview"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("member/memberview"))//return값 확인
		.andExpect(model().attributeExists("list"));//model 값 확인
	}
	
	@Test
	public void test() {
		System.out.println("--- test 실행 ---");
	}
}
