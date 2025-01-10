package com.care.root.member.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("index 실행 전 출력");
		HttpSession session = request.getSession();
		if(session.getAttribute("username") == null){
			//response.sendRedirect("login");
			String path = request.getContextPath(); //root경로 대신 넣어도 됨
			response.setContentType("text/html; charset-utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('로그인하세요');location.href='login';</script>");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("index 실행 후 출력");
	}


}
