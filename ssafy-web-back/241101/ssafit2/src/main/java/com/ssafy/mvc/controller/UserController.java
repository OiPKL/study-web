package com.ssafy.mvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.User;
import com.ssafy.mvc.model.service.UserService;

import jakarta.servlet.http.HttpSession;

/*
 * 1. 로그인 로그아웃은 어떤 메소드로 보내는게 적절한가? => POST
 * 2. session을 다루는 로직은 controller와 service중 어디서 하는게 좋을까?
 * 3. 에러처리를 어디서 해야할까? SQL error가 생겼을때 중간에서 처리해주는법		
 * 
 */

@RestController
@RequestMapping("/user")
public class UserController {
	private final UserService uService;

	public UserController(UserService uService) {
		this.uService = uService;
	}

	@GetMapping("")
	public ResponseEntity<?> getUser(HttpSession session) { // 현재 로그인된 유저 반환
		User user = (User) session.getAttribute("loginUser");
		
		if (user == null) {
			return new ResponseEntity<>("로그인 상태가 아닙니다", HttpStatus.UNAUTHORIZED);
		}

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody User user, HttpSession session) {
		if (session.getAttribute("loginUser") != null) {
			return new ResponseEntity<>("이미 로그인된 상태입니다", HttpStatus.CONFLICT);
		}

		User loginUser = uService.login(user);
		if (loginUser != null) {
			session.setAttribute("loginUser", loginUser);
			return new ResponseEntity<>(loginUser, HttpStatus.OK);
		}

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 정보가 잘못되었습니다");
	}

	@PostMapping("/logout")
	public ResponseEntity<String> logout(HttpSession session) {
		if (session.getAttribute("loginUser") == null) {
			return ResponseEntity.badRequest().body("로그인 상태가 아닙니다");
		}
		session.removeAttribute("loginUser");
		return ResponseEntity.ok("로그아웃 되었습니다");
	}

	@PostMapping("/register")
	public ResponseEntity<String> registUser(@RequestBody User user) {
		boolean success = uService.registUser(user);

		if (success) {
			return ResponseEntity.status(HttpStatus.CREATED).body("회원가입이 완료되었습니다");
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("아무튼 서버잘못은 아닙니다");
	}

}
