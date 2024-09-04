package com.multicampus.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	
	// around로 등록되는 메소드는 리턴타입(Object)과 매개변수(ProceedingJoinPoint)가 고정되어 있다.
	@Around("BoardPointcut.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable {
		
		
		Object obj = null;
		StopWatch watch = new StopWatch();
		watch.start();
		
		obj = jp.proceed(); // p.proceed() 메소드 호출을 기준으로 사전처리와 사후 처리가 나뉜다.

		watch.stop();
		
		System.out.println("===> 비즈니스 메소드 수행에 소요된 시간 : " +
				watch.getTotalTimeSeconds());
		return obj;
	}
}
