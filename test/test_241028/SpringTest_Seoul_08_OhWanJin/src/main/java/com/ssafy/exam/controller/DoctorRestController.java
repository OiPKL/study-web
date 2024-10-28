package com.ssafy.exam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.exam.model.dto.Doctor;
import com.ssafy.exam.model.service.DoctorService;

//RestController 어노테이션 명시 -> 반환 타입은 뷰가 아닌 http의 body로
///api/specialty 가 자동으로 앞에 붙게됨 (=prefix와 같은 효과)
@RestController
@RequestMapping("/api/doctor")
public class DoctorRestController {
	
	// 생성자 주입으로 Spring Bean 설정
	private final DoctorService doctorService;
	// @Autowired가 생략되어도 작동
	public DoctorRestController(DoctorService doctorService) {
		this.doctorService = doctorService;
	}

	@PostMapping("")
	// RequestBody : JSON 요청을 처리
	public ResponseEntity<?> addDoctor(@RequestBody Doctor doctor) {
		
		boolean result = doctorService.addDoctor(doctor);
		
		if (result)
			return ResponseEntity.ok(doctor);
		return ResponseEntity.badRequest().build();
	}

	@GetMapping("")
	public ResponseEntity<?> getAllDoctors() {
		
		List<Doctor> doctors = doctorService.getAllDoctors();
		
		if (doctors != null || doctors.size() > 0)
			return ResponseEntity.ok(doctors);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/{id}")
	// PathVariable : URL 에서 변수명을 가져옴
	public ResponseEntity<?> getDoctorById(@PathVariable("id") int id, Doctor doctor) {
		
		doctor = doctorService.getDoctorById(id);
		System.out.println(doctor);
		
		if (doctor != null)
			return ResponseEntity.ok(doctor);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateDoctor() {
		return null;
	}

	@DeleteMapping("{id}")
	// PathVariable : URL 에서 변수명을 가져옴
	public ResponseEntity<?> deleteDoctor(@PathVariable("id") int id) {

		boolean result = doctorService.deleteDoctor(id);
		
		return new ResponseEntity<>(result ? HttpStatus.OK: HttpStatus.BAD_REQUEST);

	}
}
