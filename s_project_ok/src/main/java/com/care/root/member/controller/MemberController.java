package com.care.root.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired MemberService ms;
	@GetMapping("login")
	public String loginForm(){
		return "/member/login";
	}
	@PostMapping("login")
	public String login( String id ) {
		System.out.println("id : " + id);
		return "forward:login_check";
	}
	@PostMapping("login_check")
	public String loginCheck(String id, String pwd,
							HttpSession session, String autoLogin, HttpServletResponse res) {
		
		int result = ms.loginCheck(id, pwd);
		
		if(result == 1) {
			if(autoLogin != null) {
				int limitTime = 60*60*24*90; //90일
				Cookie loginCookie = new Cookie("loginCookie", session.getId());
				loginCookie.setPath("/");
				loginCookie.setMaxAge(limitTime);
				res.addCookie(loginCookie);
				
				ms.keepLogin(session.getId(), id);
			}
			
			session.setAttribute("username", id);
			return "redirect:success";
		}
		return "redirect:login";
	}
	@GetMapping("success")
	public String successLogin() {
		return "member/successLogin";
	}
	@GetMapping("logout")
	public String logout(HttpSession session, HttpServletResponse res, @CookieValue(value="loginCookie", required = false) Cookie cook) {
		if(cook != null) {
			cook.setMaxAge(0);
			cook.setPath("/");
			res.addCookie(cook);
			ms.keepLogin("nan", (String)session.getAttribute("username"));
		}
		session.invalidate();
		return "redirect:login";
	}
	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("list", ms.getList() );
		return "member/memberInfo";
	}
	@GetMapping("info")
	public String info(String id, Model model) {
		MemberDTO dto = ms.getMember(id);
		String [] addr = dto.getAddr().split(",");
		model.addAttribute("member", dto);
		model.addAttribute("addr", addr);
		model.addAttribute("member", ms.getMember(id) );
		return "member/info";
	}
	@GetMapping("reg_form")
	public String reg_form() {
		return "member/register";
	}
	@PostMapping("register")
	public String reg(MemberDTO dto) {
		int result = ms.register( dto );
		if(result == 1) {
			return "redirect:login";
		}
		return "redirect:reg_form";
	}
}












