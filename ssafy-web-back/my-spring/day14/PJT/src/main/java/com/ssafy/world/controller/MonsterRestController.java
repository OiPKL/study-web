package com.ssafy.world.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.world.model.service.MonsterService;

@RestController
@RequestMapping("/api")
public class MonsterRestController {

	private final MonsterService monsterService;
	
	public MonsterRestController(MonsterService monsterService) {
		this.monsterService = monsterService;
	}
	
}
