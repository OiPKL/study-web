package com.ssafy.ws.model.service;

import java.util.List;

import com.ssafy.ws.model.dto.Car;

public interface CarService {

	public List<Car> getCarList();
	
	public Car getCar(String vin);
	
	public int registCar(Car car);
	
}
