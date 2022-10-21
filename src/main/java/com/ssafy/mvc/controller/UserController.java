package com.ssafy.mvc.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.cj.Session;
import com.ssafy.mvc.dto.User;
import com.ssafy.mvc.model.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/login")
	public String goLogin() {
		return "/user/login";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request,User user) throws SQLException {
		User loginUesUser = userService.selectById(user);
		
		//받아온 유저 정보 처리
		if (loginUesUser==null) {
			return "/user/login";
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("userInfo", user);
			return "home";
		}

		
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.invalidate();
		return "home";
	}

}
