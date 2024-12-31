package com.care.aaa;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("my")
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
	
	@RequestMapping(value="index", method = RequestMethod.GET)
	public String index() {
		return "/get_post/index";
	}
	
//	@RequestMapping(value="my/index", method = RequestMethod.GET)
	@GetMapping("result")
	public String result(HttpServletRequest req, Model model) {
		System.out.println(req.getParameter("name"));
		System.out.println(req.getParameter("age")); //jsp에서 전달하는 값
		model.addAttribute("method", req.getMethod());
		model.addAttribute("age", req.getParameter("age"));
		model.addAttribute("name", req.getParameter("name"));
		return "get_post/result";
	}
	
	@PostMapping("result")
	public String poResult(HttpServletRequest req, Model model, @RequestParam("name") String n, int age) {
		System.out.println("name : " + n);
		System.out.println("age : " + age);
		model.addAttribute("method", req.getMethod());
		model.addAttribute("age", age);
		model.addAttribute("name", n);
		return "get_post/result";
	}

	@PostMapping("object")
	public String object(MemberDTO dto, Model model) {
		System.out.println(dto.getName());
		System.out.println(dto.getAge());
		model.addAttribute("member", dto);
		return "get_post/object";
	}
	
	@GetMapping("jstl")
	public String jstl(Model model) {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		
		for(int i = 0; i < 5; i++) {
			MemberDTO d = new MemberDTO();
			d.setName("홍길동 : " + i);
			d.setAge(i * 10);
			list.add(d);
		}
		
		model.addAttribute("num", 100);
		model.addAttribute("list", list);
		return "get_post/jstl";
	}
	
}
