package com.multicampus.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	
	@Before("BoardPointcut.allPointcut()")
	public void printLog(JoinPoint jp) {

		// 클라이언트가 호출한 메소드 이름
		String method = jp.getSignature().getName();
		
		// 클라이언트가 메소드 호출할 때 전달한 인자의 목록
		Object[] args = jp.getArgs();
		
		System.out.println("[사전 처리] " + method +"() 메소드 인자 목록"+args[0].toString());
	}
}
