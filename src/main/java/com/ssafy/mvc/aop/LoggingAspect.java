package com.ssafy.mvc.aop;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//빈등록
@Component
//Aspect 관련 클래스 파일임을 알려줌
@Aspect
@Slf4j
public class LoggingAspect {

	// model 아래 service 아래 모든 클래스의 모든 메소드 대상/ (..) -> 매개변수는 0개 이상/ 맨앞 *은 반환 타입
	@Before(value = "execution(* com.ssafy.mvc.model.*.*.*(..))")
	public void logging(JoinPoint jp) {

		Signature sig = jp.getSignature();
		Object[] args = jp.getArgs();

		log.debug("메소드 선언부: {}, 전달 파라미터: {}", sig, args);
	}
	
	@Around(value = "execution(* com.ssafy.mvc.model.dao.BookDaoImpl.selectAll())")
	public Object calcTime(ProceedingJoinPoint proc) throws Throwable {
		
		//시작 시간
		long start=System.currentTimeMillis();
		//원래 메소드를 실행하는 코드
		Object result=proc.proceed();
		
		//종료 시간
		long end=System.currentTimeMillis();
		
		log.debug("수행 시간 : {}",end-start);
		return result;
		
	}
	

}
