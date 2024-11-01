package com.ssafy.world.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.world.model.dao.PlayerDao;
import com.ssafy.world.model.dto.Player;

@Service
public class PlayerServiceImpl implements PlayerService {

	private final PlayerDao playerDao;
	
	public PlayerServiceImpl(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}
	
	@Override
	public List<Player> getPlayers() {
		System.out.println("역사책 오픈!");
		
		return playerDao.selectAll();
	}

	@Override
	public Player getPlayer(int id) {
		System.out.println("플레이어 상태창 오픈!");
		
		return playerDao.selectOne(id);
	}

	@Override
	public boolean registPlayer(Player player) {
		System.out.println("플레이어 추가 완료!");
		
		int result = playerDao.insertPlayer(player);
		
		return result > 0;
	}
	
}
