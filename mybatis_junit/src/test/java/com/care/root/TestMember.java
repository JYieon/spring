package com.care.root;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.care.root.member.controller.MemberController;
import com.care.root.member.dao.MemberDAO;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:testMember.xml", 
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"})//해당 파일을 읽음
public class TestMember {

	@Autowired MemberController mc; //bean 자동주입
	@Autowired MemberService ms;
	@Autowired MemberDAO dao;
	
	@Test
	public void testMc() {
		System.out.println("--- mc => " + mc);
		assertNotNull(mc); //해당 객체가 null인지 확인(null이 아니면 test 성공)
	}
	
	@Test
	public void testMs() {
		MemberDTO dto = new MemberDTO();
		dto.setId(1);
		dto.setName("홍길동");
		int result = ms.insertMember(dto); //가짜데이터 넣어보기
		System.out.println("result : " + result);
		assertEquals(1, result); //결과값이 1과 같다면 test 성공
		assertNotNull(dao);
	}
	
	@Test
	public void testDao() {
		MemberDTO dto = new MemberDTO();
		dto.setId(1);
		dto.setName("홍길동");
		int result = dao.insertMember(dto); //가짜데이터 넣어보기
		System.out.println("result : " + result);
		assertEquals(1, result); //결과값이 1과 같다면 test 성공
		assertNotNull(dao);
	}
	
	@Test
	public void getList() {
		ArrayList<MemberDTO> list = dao.getList();
		System.out.println(list.size());
		System.out.println(list.get(0).getName());
		assertNotNull(list);
	}
}
