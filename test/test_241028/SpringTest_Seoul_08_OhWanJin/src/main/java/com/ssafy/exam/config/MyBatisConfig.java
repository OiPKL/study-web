package com.ssafy.exam.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

// com.ssafy.exam.model.dao 패키지 내의 클래스들을 mapper로 등록
@MapperScan("com.ssafy.exam.model.dao")
@Configuration
public class MyBatisConfig {

}
