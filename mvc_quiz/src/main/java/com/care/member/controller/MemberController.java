package com.care.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.member.dao.MemberDAO;
import com.care.member.dto.MemberDTO;
import com.care.member.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
	@Autowired
	MemberService ms = new MemberService();
	
	public MemberController() {
		System.out.println("quizMemberController");
	}
	
	@RequestMapping("main")
	public String main() {
		return "/member/main";
	}
	
	@GetMapping("register")
	public String register_form() {
		return "/member/register";
	}
	
	@PostMapping("register")
	public String register(MemberDTO d) {	
		ms.setList(d);
		return "redirect:test";
		//return "forward:test";
	}
	
	@GetMapping("test")
	public String test() {
		System.out.println("get방식 test실행");
		return "/member/main";
	}
	
	@PostMapping("test")
	public String test2() {
		System.out.println("post방식 test실행");
		return "/member/main";
	}
	
	@GetMapping("list")
	public String list(Model model) {
		ArrayList<MemberDTO> list = ms.getList();
		System.out.println(list);
		model.addAttribute("member", list);
		
		return "/member/list";
	}
	
	@GetMapping("abc")
	public String abc() {
		//중간에 무언가 연산 후 목록으로 이동시켜줌
		return "redirect:list";
	}
	
}
