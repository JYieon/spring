package com.care.root.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CookieController {
	
	@Autowired(required = false) ServiceTest st;
	
	@GetMapping("cookie")
	public String cookie(HttpServletResponse res) {
		System.out.println("ServiceTest : " + st);
		Cookie cookie = new Cookie("key", "cookie값");
		cookie.setMaxAge(10); //유지시간(초)
		res.addCookie(cookie);
		return "cookie";
	}
	
	@GetMapping("cookie_check")
	public String cookie_check(HttpServletRequest req, @CookieValue(value="key", required = false) Cookie cook) {
		System.out.println("cook : " + cook);
		if(cook != null) {
			System.out.println("cook name : " + cook.getName());
			System.out.println("cook value : " + cook.getValue());	
		}
		System.out.println("----------------------------------");		
		Cookie[] cookie = req.getCookies();
		for(Cookie c : cookie) {
			System.out.println(c.getName() + ":" + c.getValue());
		}
		return "cookie";
	}
	
	@GetMapping("cookie02")
	public String cookie02(Model model, @CookieValue(value="key", required = false) Cookie cook) {
		if(cook != null) {
			model.addAttribute("cook", cook.getName());
		}
		return "cookie02";
	}
	
	@GetMapping("popup02")
	public String popup02() {
		return "popup02";
	}
	
	@GetMapping("cookieCreate")
	public void cookieCreate(HttpServletResponse res) {
		System.out.println("cookie실행");
		Cookie cookie02 = new Cookie("key", "cookie값");
		cookie02.setMaxAge(5);
		cookie02.setPath("/");
		res.addCookie(cookie02);
	}
}
