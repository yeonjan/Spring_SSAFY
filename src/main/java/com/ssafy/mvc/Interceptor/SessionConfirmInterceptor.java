package com.ssafy.mvc.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.mvc.dto.User;

public class SessionConfirmInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		//1. 세션에서 유저 정보가 있는지 체크
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("userInfo");
		
		//2-1. 유저 정보가 있는 경우 요청을 컨트롤러로 정상적으로 보냄
		if (user!=null) {
			return true;
		}
		//2-2. 유저 정보가 없는 경우 홈페이지로 전달
		else {
			response.sendRedirect(request.getContextPath()+"/");
			return false;
		}

	}

}
