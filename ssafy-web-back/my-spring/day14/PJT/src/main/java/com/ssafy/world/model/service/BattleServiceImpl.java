package com.ssafy.world.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.world.model.dao.MonsterDao;
import com.ssafy.world.model.dao.PlayerDao;
import com.ssafy.world.model.dto.Damage;
import com.ssafy.world.model.dto.Monster;
import com.ssafy.world.model.dto.Player;

@Service
public class BattleServiceImpl implements BattleService {

	private final PlayerDao playerDao;
	private final MonsterDao monsterDao;
	
	public BattleServiceImpl(PlayerDao playerDao, MonsterDao monsterDao) {
		this.playerDao = playerDao;
		this.monsterDao = monsterDao;
	}
	
	@Override
	public int choosePlayer() {
		
		List<Player> players = playerDao.selectAll();
		
		if (!players.isEmpty()) {
			for (Player player : players) {
				if (player.isAlive()) {
					System.out.println("플레이어 소환 완료!");
					
					return player.getId();
				}
			}
			System.out.println("플레이어 소환 실패");
			
			return -1; 
		} else {
			System.out.println("플레이어 소환 실패");
			
			return -1;
		}
	}

	@Override
	public int chooseMonster() {
		
		List<Monster> monsters = monsterDao.selectAll();
		
		if (!monsters.isEmpty()) {
			for (Monster monster : monsters) {
				if (monster.isAlive()) {
					System.out.println("몬스터 소환 완료!");
					
					return monster.getId();
				}
			}
			System.out.println("몬스터 소환 실패");
			
			return -1; 
		} else {
			System.out.println("몬스터 소환 실패");
			
			return -1;
		}
	}

	@Override
	public void startBattle() {
		
		int playerId = choosePlayer();
		int monsterId = chooseMonster();
		
		if (playerId == -1 || monsterId == -1) {
			System.out.println("배틀 준비 중");
			return;
		}
		
		System.out.println("배틀 시작!");

		Player player = playerDao.selectOne(playerId);
		Monster monster = monsterDao.selectOne(monsterId);
		
		System.out.println(player);
		System.out.println(monster);
		
		int playerHp = player.getHp();
		int playerAtk = player.getAtk();
		int monsterHp = monster.getHp();
		int monsterAtk = monster.getAtk();
		int playerTurn = playerHp / monsterAtk;
		int monsterTurn = monsterHp / playerAtk;
		
		if (playerTurn > monsterTurn) {
			int damage = playerHp - monsterAtk * monsterTurn;
			
			playerDao.decreasePlayerHp(new Damage(monsterId, damage));
			monsterDao.invalidateMonster(monsterId);
		} else if (playerTurn < monsterTurn) {
			int damage = monsterHp - playerAtk * playerTurn;
			
			monsterDao.decreaseMonsterHp(new Damage(monsterId, damage));
			playerDao.invalidatePlayer(playerId);
		} else {
			playerDao.invalidatePlayer(playerId);
			monsterDao.invalidateMonster(monsterId);
		}
		
		System.out.println("배틀 종료!");
	}

}
