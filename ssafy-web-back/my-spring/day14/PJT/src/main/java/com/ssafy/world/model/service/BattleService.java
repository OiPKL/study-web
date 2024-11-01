package com.ssafy.world.model.service;

public interface BattleService {
	// 플레이어 소환
	public int choosePlayer();
	
	// 몬스터 소환
	public int chooseMonster();
	
	// 배틀 시작
	public void startBattle();
}
