package com.ssafy.world.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.world.model.dao.MonsterDao;
import com.ssafy.world.model.dto.Monster;

@Service
public class MonsterServiceImpl implements MonsterService {

	private final MonsterDao monsterDao;
	
	public MonsterServiceImpl(MonsterDao monsterDao) {
		this.monsterDao = monsterDao;
	}
	
	@Override
	public List<Monster> getMonsters() {
		System.out.println("몬스터도감 오픈!");
		
		return monsterDao.selectAll();
	}

	@Override
	public Monster getMonster(int id) {
		System.out.println("몬스터 상태창 오픈!");
		
		return monsterDao.selectOne(id);
	}

	@Override
	public boolean resetWorld() {
		System.out.println("몬스터 초기화 완료!");
		
		int result = monsterDao.validateMonsters();
		
		return result > 0;
	}

}
