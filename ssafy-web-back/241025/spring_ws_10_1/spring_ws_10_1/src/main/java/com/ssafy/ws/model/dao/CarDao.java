package com.ssafy.ws.model.dao;

import java.util.List;

import com.ssafy.ws.model.dto.Car;

public interface CarDao {

	public abstract List<Car> selectAll();
	
	public abstract Car selectOne(String vin);
	
	public int insertCar(Car car);
	
}
