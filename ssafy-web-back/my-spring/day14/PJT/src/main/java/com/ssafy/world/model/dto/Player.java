package com.ssafy.world.model.dto;

public class Player {
	private int id;
	private String name;
	private int hp;
	private int atk;
	private boolean isAlive;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", hp=" + hp + ", atk=" + atk + ", isAlive=" + isAlive + "]";
	}
}
