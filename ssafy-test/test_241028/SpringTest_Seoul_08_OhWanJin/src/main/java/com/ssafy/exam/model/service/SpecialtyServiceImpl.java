package com.ssafy.exam.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.exam.model.dao.SpecialtyDao;
import com.ssafy.exam.model.dto.Specialty;

//@Service annotaion 추가
// SpecialtyService Interface를 사용해 SpecialtyService 클래스 생성
@Service
public class SpecialtyServiceImpl implements SpecialtyService {
	
	// 생성자 주입으로 Spring Bean 설정
	private final SpecialtyDao specialtyDao;
	// @Autowired가 생략되어도 작동
	public SpecialtyServiceImpl(SpecialtyDao specialtyDao) {
		this.specialtyDao = specialtyDao;
	}

	@Override
	public boolean addSpecialty(Specialty specialty) {
		
		// 반환값은 int형이므로 boolean 타입으로 변환이 필요함
		// int형 반환 이유 = 수정된 sql문의 행 개수가 반환되기 때문
		// 0 = false / 1 = true
		int result = specialtyDao.insertSpecialty(specialty);
		
		return (result == 1 ? true : false);
	}

	@Override
	public Specialty getSpecialtyByCode(int code) {
		
		// Specialty DTO 객체를 반환함
		return specialtyDao.selectSpecialtyByCode(code);
	}

	@Override
	public boolean deleteSpecialty(int code) {
		
		// 반환값은 int형이므로 boolean 타입으로 변환이 필요함
		// int형 반환 이유 = 수정된 sql문의 행 개수가 반환되기 때문
		// 0 = false / 1 = true
		int result = specialtyDao.deleteSpecialty(code);
		
		return (result == 1 ? true : false);
	}

}
