package com.ssafy.world.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.world.model.dto.Player;
import com.ssafy.world.model.service.BattleService;
import com.ssafy.world.model.service.MonsterService;
import com.ssafy.world.model.service.PlayerService;

@RestController
@RequestMapping("/api/player")
public class PlayerRestController {

	private final PlayerService playerService;
	
	public PlayerRestController(PlayerService playerService) {
		this.playerService = playerService;
	}
	
	@GetMapping("")
	public ResponseEntity<?> playerList(){
		
		List<Player> list = playerService.getPlayers();
		
		if (list == null || list.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> playerStatus(@PathVariable("id") int id){
		
		Player player = playerService.getPlayer(id);
		
		if (player == null)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return ResponseEntity.ok(player);
	}
}
