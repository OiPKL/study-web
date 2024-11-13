package com.ssafy.mvc.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	private String key = "SSAFY_NonMajor_JavaTrack_SecretKey";
	private SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
	
	// 토큰 생성 시 다양한 데이터를 저장 (DTO or Map)
	public String createToken(String name) {
		// 유효기간 1시간
		Date exp = new Date(System.currentTimeMillis()+ 1000*60*60);
		return Jwts.builder()
				.header().add("typ", "JWT").and()		// 헤더
				.claim("name", name).expiration(exp)	// 페이로드
				.signWith(secretKey).compact();			// 서명
	}
	
	// 에러 발생 여부로 토큰 유효성 검증
	public Jws<Claims> validate(String token){
		return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);
	}
}
