package com.ssafy.board.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.User;

@RestController
@RequestMapping("/rest5")
public class RestController5 {
	// 폼 데이터 형식으로 전달
	@PostMapping("/board1")
	public String test1(@ModelAttribute User user) {
		return user.toString();
	}
	
	// JSON 데이터 형식으로 전달
	@PostMapping("/board2")
	public String test2(@RequestBody User user) {
		return user.toString();
	}
	
/*
{
  "id" : "ssafy",
  "password" : "0000",
  "name" : "박싸피"
}
 */
	
}
