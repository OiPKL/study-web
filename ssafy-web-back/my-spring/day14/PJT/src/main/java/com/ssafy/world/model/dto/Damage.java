package com.ssafy.world.model.dto;

public class Damage {
	private int id;
	private int damage;

	public Damage(int id, int damage) {
		super();
		this.id = id;
		this.damage = damage;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	@Override
	public String toString() {
		return "Damage [id=" + id + ", damage=" + damage + "]";
	}
}
