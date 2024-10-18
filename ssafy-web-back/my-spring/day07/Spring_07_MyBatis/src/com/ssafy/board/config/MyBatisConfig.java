package com.ssafy.board.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConfig {

	private static SqlSessionFactory factory;
	
	static {
		// factory 설정 파일 위치
		String resource = "mybatis-config.xml";
		try(InputStream inputStream = Resources.getResourceAsStream(resource)){
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println("fatcory 빌드 성공");
		} catch (IOException e) {
			System.out.println("fatcory 빌드 실패");
		}
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}

}
