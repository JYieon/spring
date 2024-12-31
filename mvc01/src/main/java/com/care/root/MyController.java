package com.care.root;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	
	public MyController() {
		System.out.println("--- my ctrl 생성자 ---");
	}
	
	@RequestMapping("/index")
	public String test(Model model) {
		System.out.println("--- test 연동 ---");
		model.addAttribute("request","기본 페이지 입니다.");
		return "/member/index"; //views 다음 위치부터 작성	
	}
	
	@RequestMapping("/logout")
	public String logout(Model model) { //자동적으로 객체 주입
		model.addAttribute("test", "로그아웃 되었습니다"); //key:value
		model.addAttribute("key", "원하는 값");
		return "/member/logout"; //model이 자동으로 전해짐
	}	
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("el", "로그인 페이지 입니다.");
		mv.addObject("login", "로그인 페이지 값 전달");
		mv.setViewName("/member/login");
		return mv;
	}

}
