package com.ssafy.exam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.exam.model.dto.Specialty;
import com.ssafy.exam.model.service.SpecialtyService;

// RestController 어노테이션 명시 -> 반환 타입은 뷰가 아닌 http의 body로
// /api/specialty 가 자동으로 앞에 붙게됨 (=prefix와 같은 효과)
@RestController
@RequestMapping("/api/specialty")
public class SpecialtyRestController {
	
	// 생성자 주입으로 Spring Bean 설정
	private final SpecialtyService specialtyService;
	// @Autowired가 생략되어도 작동
	public SpecialtyRestController(SpecialtyService specialtyService) {
		this.specialtyService = specialtyService;
	}
	
	@PostMapping("")
	// RequestBody : JSON 요청을 처리
	public ResponseEntity<?> addSpecialty(@RequestBody Specialty specialty) {
		
		boolean result = specialtyService.addSpecialty(specialty);
		
		if (result)
			return ResponseEntity.ok(specialty);
		return ResponseEntity.badRequest().build();
	}

	@GetMapping("/{code}")
	// PathVariable : URL 에서 변수명을 가져옴
	public ResponseEntity<?> getSpecialty(@PathVariable("code") int code, Specialty specialty) {
		
		specialty = specialtyService.getSpecialtyByCode(code);
		System.out.println(specialty);
		
		if (specialty != null)
			return ResponseEntity.ok(specialty);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{code}")
	// PathVariable : URL 에서 변수명을 가져옴
	public ResponseEntity<?> deleteSpecialty(@PathVariable("code") int code) {

		boolean result = specialtyService.deleteSpecialty(code);
		
		return new ResponseEntity<>(result ? HttpStatus.OK: HttpStatus.BAD_REQUEST);
	}
}