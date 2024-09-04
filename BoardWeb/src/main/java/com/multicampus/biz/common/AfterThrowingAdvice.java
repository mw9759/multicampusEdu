package com.multicampus.biz.common;

import java.sql.SQLException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
	
	// after-throwing은 바즈니스 메소드에서 발생된 예외 객체를 받아서 사후처리 할 수 있다.
	@AfterThrowing(pointcut = "BoardPointcut.allPointcut()", throwing = "exceptionObj")
	public void exceptionLog(JoinPoint jp, Exception exceptionObj) {

		String method = jp.getSignature().getName();
		System.out.println("[예외 처리] "+ method+ "() 메소드 수행 중 예외 발생");
		
		// 발생된 예외의 타이벵 따른 분기처리 가능
		if(exceptionObj instanceof IllegalArgumentException) {
			System.out.println("0번 글은 등록할 수 없습니다.");
		}
		else if(exceptionObj instanceof SQLException) {
			System.out.println("SQL 구문에 문법 오류가 있습니다.");
		}
		else {
			System.out.println("원인 미상의 문제 발생!");
		}
	}
}
