package com.care.root.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionController {

	@GetMapping("make_session")
	public String makeSession(HttpServletRequest req, HttpSession se) {
		HttpSession s = req.getSession(); //session값 얻어오기
		s.setAttribute("name", "홍길동");
		se.setAttribute("id", "aaa");
		return "session/makeSession";
	}
	@GetMapping("result_session")
	public String result_session(HttpSession session, Model model) {
		model.addAttribute("addr", "산골짜기");//현재 연결된 page까지만 사용 가능. session은 다른 page에도 사용 가능
		model.addAttribute("id", "session ID");
//		model과 session의 key가 동일할 경우 model의 값이 전달된다.(범위가 작은 쪽이 우선시)
		System.out.println("id : " + session.getAttribute("id"));
		System.out.println("name : " + session.getAttribute("name"));
		System.out.println("없는값 : " + session.getAttribute("없는값"));
		return "session/result_session";
	}
	@GetMapping("del_session")
	public String delSession(HttpSession session) {
		//session.removeAttribute("id"); // 특정 세션 만료
		session.invalidate(); //모든 세션 만료
		return "session/del_session";
	}

}
