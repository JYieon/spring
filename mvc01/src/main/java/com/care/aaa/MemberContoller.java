package com.care.aaa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberContoller {
	@Autowired
	MemberService ms;
	
	@RequestMapping("/test")
	public String test() {
		System.out.println("ms => " + ms);
		ms.test();
		return "/test/index";
	}
	public MemberContoller() {
		System.out.println("MemberContoller");
	}

}
