package com.ssafy.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	private final UserService userService;
	
//	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "/user/loginform";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		
		User user1 = userService.login(user.getId(), user.getPassword());
		
		// user1 로그인성공 -> User 정보
		// user1 로그인실패 -> null
		
		if (user1 == null)
			return "redirect:login";
		
		session.setAttribute("loginUser", user1.getName());
		
		return "redirect:list";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:list";
	}
	
	@GetMapping("/users")
	public String userList(Model model) {
		model.addAttribute("userList", userService.getUserList());
		
		return "/user/adminPage";
	}
	
	@GetMapping("/signup")
	public String signupForm() {
		return "/user/signupform";
	}
	
	@PostMapping("/signup")
	public String signup(@ModelAttribute User user) {
		userService.signup(user);
		
		return "redirect:list";
	}
}
