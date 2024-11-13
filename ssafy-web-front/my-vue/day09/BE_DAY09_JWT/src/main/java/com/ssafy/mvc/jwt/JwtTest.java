package com.ssafy.mvc.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtTest {
	public static void main(String[] args) throws InterruptedException {

		// 개인키 생성 (key 암호화)
		String key = "SSAFY_NonMajor_JavaTrack_SecretKey";
		SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));

		Map<String, String> headers = new HashMap<>();
		headers.put("typ", "JWT");
		
		// JWT: 헤더 + 페이로드(데이터) + 서명
		String token = Jwts.builder()
			.header()																// JWT -> JWT header
			.add("name", "choi").add(headers).and()									// JWT header -> JWT
			.subject("ssafy").expiration(new Date(System.currentTimeMillis()+3000))	// 유효시간: 3초
			.signWith(secretKey)													// 서명 완료
			.compact();
		
		System.out.println(token);													// 토큰 유효기간 확인
		
		Thread.sleep(4000);
		
		Jws<Claims> jwsClaims = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);
		
		System.out.println(jwsClaims.getHeader());
		System.out.println(jwsClaims.getPayload());
	}
}
