package com.care.member.forward;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {
	
	@GetMapping("login_form")
	public String loginForm() {
		return "login/login_form";
	}
	
	@PostMapping("login")
	public String login(String id, String pwd) {
		
		return "forward:login_check";
	}
	
	@PostMapping("login_check")
	public String loginCheck(String id, String pwd) {
		String dbId = "1", dbPwd = "1";
		if(dbId.equals(id) && dbPwd.equals(pwd)) {
			return "redirect:index";
		}else {
			return "redirect:login_form";
		}	 	
	}
	
	@GetMapping("index")
	public String index() {
		return "login/main";
	}
}
