package com.care.root.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@GetMapping("login")
	public String login() {
		return "login/login";
	}
	
	@PostMapping("login")
	public String loginCheck(String id, String pwd) {
		String dbId = "1", dbPwd = "1";
		if(dbId.equals(id) && dbPwd.equals(pwd)) {

		}
		return "forward:login_check";
	}

	@PostMapping("login_check")
	public String login_check(HttpSession session, String id, String pwd) {
		String dbId = "1", dbPwd = "1", nick = "홍길동";
		if(dbId.equals(id) && dbPwd.equals(pwd)) {
			session.setAttribute("login", nick);
			return "redirect:main";
		}else {
			return "redirect:login";
		}
	}
	
	@GetMapping("main")
	public String main(HttpSession session) {
//		if(session.getAttribute("login") == null) {
//			return "redirect:login";
//		}
		return "login/main";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
}
