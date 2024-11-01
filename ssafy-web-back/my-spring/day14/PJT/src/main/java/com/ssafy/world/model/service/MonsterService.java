package com.ssafy.world.model.service;

import java.util.List;

import com.ssafy.world.model.dto.Monster;

public interface MonsterService {
	// 몬스터도감 오픈
	public List<Monster> getMonsters();
	
	// 몬스터 상태창 오픈
	public Monster getMonster(int id);
	
	// 몬스터 초기화
	public boolean resetWorld();
}
