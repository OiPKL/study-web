package com.example.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.mvc.model.dto.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@GetMapping("/login")
	public String loginForm() {
		return "user/loginForm";
	}
	
//	@PostMapping("/login")
//	public String login(@RequestParam("id") String id, @RequestParam("pw") String pw) {
//		System.out.println(id);
//		System.out.println(pw);
//		// 포워딩 -> prefix/hello.jsp ~ 공백처리가 됨
////		return "hello";
//		return "redirect:hello";
//	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		System.out.println(user);
		
		// UserService 통해서 id&pw ~ DB 확인 ~ 실제 유저 검증 ~ 세션 필요
		// 서비스를 구현하지 않아서 user의 id를 직접 넣음 -> 실제로는 인증 받은 정보만 필요
		// 세션에는 ID&PW 가 아닌 ID만 저장
		session.setAttribute("loginUser", user.getId());
		
		// 포워딩 -> prefix/hello.jsp ~ 공백처리가 됨
//		return "hello";
		return "redirect:hello";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		// 1. 세션에서 유저 속성을 제거
		session.removeAttribute("loginUser");
		// 2. 세션 자체를 초기화
//		session.invalidate();
		
		return "redirect:/";
	}
}
