package com.ssafy.world.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.world.model.service.BattleService;

@RestController
@RequestMapping("/api")
public class BattleRestController {

	private final BattleService battleService;
	
	public BattleRestController(BattleService battleService) {
		this.battleService = battleService;
	}
	
}
