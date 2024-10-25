package com.ssafy.ws.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ws.model.dao.CarDao;
import com.ssafy.ws.model.dto.Car;

@Service
public class CarServiceImpl implements CarService {
	
	private final CarDao carDao;
	
	public CarServiceImpl(CarDao carDao) {
		this.carDao = carDao;
	}

	@Override
	public List<Car> getCarList() {
		System.out.println("리스트 반환 완료");
		return carDao.selectAll();
	}

	@Override
	public Car getCar(String vin) {
		System.out.println(vin+"번 차량");
		return carDao.selectOne(vin);
	}

	@Transactional
	@Override
	public int registCar(Car car) {
		System.out.println("차량 등록 완료");
		int result = carDao.insertCar(car);
		
		return result;
	}

}
