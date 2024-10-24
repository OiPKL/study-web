package com.ssafy.board.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.User;

@RestController
@RequestMapping("/rest2")
public class RestController2 {

	// 반환타입이 문자열 -> View Resolver가 Hello REST API.jsp를 반환
	@GetMapping("/test1")
	public String test1() {
		return "Hello REST API";
	}
	
	// @ResponseBody -> 데이터를 body에 담아 반환
	@GetMapping("/test2")
	public String test2() {
		return "Hello REST API";
	}
	
	@GetMapping("/test3")
	public Map<String, String> test3() {
		
		Map<String, String> data = new HashMap<>();
		data.put("id", "ssafy");
		data.put("pw", "1234");
		
		return data;
	}
	
	@GetMapping("/test4")
	public User test4(){
		
		User user = new User("ssafy", "1234", "김싸피");
		
		return user;
	}
	
	@GetMapping("/test5")
	public List<User> test5(){
		
		List<User> list = new ArrayList<>();
		list.add(new User("ssafy1", "1234", "김싸피"));
		list.add(new User("ssafy2", "1234", "김싸피"));
		list.add(new User("ssafy3", "1234", "김싸피"));
		list.add(new User("ssafy4", "1234", "김싸피"));
		list.add(new User("ssafy5", "1234", "김싸피"));
		list.add(new User("ssafy6", "1234", "김싸피"));
		list.add(new User("ssafy7", "1234", "김싸피"));
		
		return list;
	}
}
