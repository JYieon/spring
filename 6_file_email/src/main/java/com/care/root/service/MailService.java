package com.care.root.service;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired JavaMailSender mailSender;

	public void sendMail(String to, String subject, String body) {//받는 이, 제목, 내용
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8"); //전송할 내용 설정
			helper.setSubject(subject);
			helper.setTo(to);
			helper.setText(body);
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendMail02(String to, String subject, String body) {//받는 이, 제목, 내용
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8"); //전송할 내용 설정
			helper.setSubject(subject);
			helper.setTo(to);
			helper.setText(body, true);
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void auth(String email, String contextPath, HttpSession session) {
		
		BCryptPasswordEncoder en = new BCryptPasswordEncoder();
		
		String userName = "choijiyeon";
		String userKey = en.encode(email);
		//session.setAttribute("username", userName);
		session.setAttribute("userKey", userKey);
		String body = "<h3>인증하기</h3>";
		body += "<a href='http://localhost:8080"+ contextPath +
				"/auth_check?username=" + userName + "&userkey=" + userKey + "'>";
		body += "인증하기</a>";
		
		sendMail02(email, "인증", body);
	}
	
   private String rand() {
	      Random ran = new Random();
	      String str="";
	      int num;
	      while(str.length() != 20) {
	         num = ran.nextInt(75)+48;//0~74 + 48 (숫자,소문자, 대문자)
	         if((num>=48 && num<=57)||(num>=65 && num<=90)||(num>=97 && num<=122)) {
	            str+=(char)num;
	         }else {
	            continue;
	         }
	      }
	      return str;
	   }
}
