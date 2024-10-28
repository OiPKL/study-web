package com.ssafy.exam.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.exam.model.dto.Specialty;

// @Service annotaion 추가
@Service
public interface SpecialtyService {
	
	boolean addSpecialty(Specialty specialty);

	Specialty getSpecialtyByCode(int code);

	boolean deleteSpecialty(int code);
}