package com.ssafy.mvc.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String login(HttpSession session, User user) throws SQLException {
		User loginUesUser = userService.selectById(user);

		// 받아온 유저 정보 처리
		if (loginUesUser == null) {
			return "/user/login";
		} else {
			session.setAttribute("userInfo", user);
			return "home";
		}

	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "home";
	}

}
