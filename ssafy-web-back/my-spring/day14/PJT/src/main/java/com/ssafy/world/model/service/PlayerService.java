package com.ssafy.world.model.service;

import java.util.List;

import com.ssafy.world.model.dto.Player;

public interface PlayerService {
	// 역사책 오픈
	public List<Player> getPlayers();
	
	// 플레이어 상태창 오픈
	public Player getPlayer(int id);
	
	// 플레이어 추가
	public boolean registPlayer(Player player);
	
}
