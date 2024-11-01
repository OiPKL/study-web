package com.ssafy.world.model.dao;

import java.util.List;

import com.ssafy.world.model.dto.Damage;
import com.ssafy.world.model.dto.Monster;

public interface MonsterDao {
	// 전체 몬스터 조회
	public List<Monster> selectAll();
	
	// 몬스터 조회
	public Monster selectOne(int id);
	
	// 전체 몬스터 초기화
	public int validateMonsters();
	
	// 몬스터 수정(사망)
	public int invalidateMonster(int id);
	
	// 몬스터 수정(hp-)
	public int decreaseMonsterHp(Damage damage);
}
