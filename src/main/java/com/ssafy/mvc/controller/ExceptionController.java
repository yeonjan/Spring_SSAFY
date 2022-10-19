package com.ssafy.mvc.controller;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(Exception.class)
	public String HandlerException(Exception e,Model model) {
		e.printStackTrace();
		String msg="처리 중 오류가 발생하였습니다.";
		if(e instanceof SQLException) {
			msg="DB 관련 오휴 발생";
		}
		
		model.addAttribute("msg",msg);
		
		return "error/500";
		
	}
	
	
	//404 발생 시 처리 메소드
	@ExceptionHandler(NoHandlerFoundException.class)
	//응답 상태 코드 설정
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String notFound(NoHandlerFoundException e) {
		
		e.printStackTrace();
		return "error/404";
	}
	

}
