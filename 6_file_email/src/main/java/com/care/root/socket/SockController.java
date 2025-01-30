package com.care.root.socket;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SockController {
	
	@GetMapping("index")
	public String index(HttpSession session) {
		return "sock/sock_index";
	}
	
	int i = 0;
	@GetMapping("chat")
	public String chat(HttpSession session) {
		i++;
		session.setAttribute("username", "홍길동-" + i);
		return "sock/chat";
	}
}
