package com.bzeromo.board.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyAppSqlConfig {
	
	private static SqlSession session;
	//session 생성
	
	static {
		//MyBatis 설정 파일 불러오기
		try {
			String resource = "config/mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
			//true 옵션 설정 시 자동 커밋
			session = sqlSessionFactory.openSession(true);
			System.out.println("세션 생성 성공");
		} catch (IOException e) {
			System.out.println("세션 생성 실패");
		}
		
	}
	
	public static SqlSession getSession() {
		return session;
	}
}
