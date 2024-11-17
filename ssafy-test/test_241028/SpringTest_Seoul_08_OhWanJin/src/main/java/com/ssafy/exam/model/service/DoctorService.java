package com.ssafy.exam.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.exam.model.dto.Doctor;

//@Service annotaion 추가
@Service
public interface DoctorService {
	boolean addDoctor(Doctor doctor);

	List<Doctor> getAllDoctors();

	Doctor getDoctorById(int id);

	boolean updateDoctor(int id, Doctor doctor);

	boolean deleteDoctor(int id);
}