package com.ssafy.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ws.model.dto.Car;
import com.ssafy.ws.model.service.CarService;


@RestController
@RequestMapping("/carapi/car")
@CrossOrigin("*")
public class CarRestController {
	
	private final CarService carService;
	
	@Autowired
	public CarRestController(CarService carService) {
		this.carService = carService;
	}
	
	@GetMapping("")
	public ResponseEntity<?> list(){
		
		List<Car> list = carService.getCarList();
		
		if (list == null || list.size() == 0)
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{vin}")
	public ResponseEntity<?> detail(@PathVariable("vin") String vin){
		
		Car car = carService.getCar(vin);
		System.out.println(car);
		
		if (car == null)
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.ok(car);
	}
	
	@PostMapping("")
//	public ResponseEntity<?> register(@ModelAttribute Car car){
	public ResponseEntity<?> register(@RequestBody Car car){
		
		int result = carService.registCar(car);
		System.out.println(car);
		
		return new ResponseEntity<>(result, result == 1 ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
	}
}
