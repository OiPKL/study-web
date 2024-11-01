package com.ssafy.world.model.dao;

import java.util.List;

import com.ssafy.world.model.dto.Damage;
import com.ssafy.world.model.dto.Player;

public interface PlayerDao {
	// 전체 플레이어 조회
	public List<Player> selectAll();
	
	// 플레이어 조회
	public Player selectOne(int id);
	
	// 플레이어 추가
	public int insertPlayer(Player player);
	
	// 플레이어 수정(사망)
	public int invalidatePlayer(int id);
	
	// 플레이어 수정(hp-)
	public int decreasePlayerHp(Damage damage);
}
