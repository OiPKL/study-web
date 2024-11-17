package com.ssafy.exam.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.exam.model.dao.DoctorDao;
import com.ssafy.exam.model.dto.Doctor;

//@Service annotaion 추가
// DoctorService Interface를 사용해 DoctorServiceImpl 클래스 생성
@Service
public class DoctorServiceImpl implements DoctorService {
	
	// 생성자 주입으로 Spring Bean 설정
	private final DoctorDao doctorDao;
	// @Autowired가 생략되어도 작동
	public DoctorServiceImpl(DoctorDao doctorDao) {
		this.doctorDao = doctorDao;
	}
	
	@Override
	public boolean addDoctor(Doctor doctor) {
		
		// 반환값은 int형이므로 boolean 타입으로 변환이 필요함
		// int형 반환 이유 = 수정된 sql문의 행 개수가 반환되기 때문
		// 0 = false / 1 = true
		int result = doctorDao.insertDoctor(doctor);
		
		return (result == 1 ? true : false);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		
		// Doctor DTO 객체가 담긴 리스트를 반환함
		return doctorDao.selectAllDoctors();
	}

	@Override
	public Doctor getDoctorById(int id) {
		
		// 해당 id를 가지는 Doctor DTO 객체를 반환함
		return doctorDao.selectDoctorById(id);
	}

	@Override
	public boolean updateDoctor(int id, Doctor doctor) {
		
		// 해당 id를 가지는 Doctor DTO 객체를 주머니에 담는다
		Doctor doctor0 = doctorDao.selectDoctorById(id);
		
		// 반환값은 int형이므로 boolean 타입으로 변환이 필요함
		// int형 반환 이유 = 수정된 sql문의 행 개수가 반환되기 때문
		// 0 = false / 1 = true
		int result = doctorDao.updateDoctor(doctor0);
		
		return (result == 1 ? true : false);
	}

	@Override
	public boolean deleteDoctor(int id) {
		
		// 반환값은 int형이므로 boolean 타입으로 변환이 필요함
		// int형 반환 이유 = 수정된 sql문의 행 개수가 반환되기 때문
		// 0 = false / 1 = true
		int result = doctorDao.deleteDoctor(id);
		
		return (result == 1 ? true : false);
	}

}
