package com.care.aaa;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ms") 
public class MemberService {
	@Inject
	@Qualifier("memberDAO")
	MemberDAO dao;
	
	public MemberService() {
		System.out.println("MemberService");
	}
	
	public void test() {
 		System.out.println(dao + "test 서비스 연결");
	}

}
