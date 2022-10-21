package com.ssafy.mvc.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mvc.dto.User;
import com.ssafy.mvc.model.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	UserMapper userMapper;
	
	public User selectById(User user) throws SQLException {
		return userMapper.selectById(user);
		
	}
	
}
