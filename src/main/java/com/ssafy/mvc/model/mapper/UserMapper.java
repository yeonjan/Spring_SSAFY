package com.ssafy.mvc.model.mapper;

import java.sql.SQLException;


import com.ssafy.mvc.dto.User;

public interface UserMapper {

	//유저 정보 조회
	User selectById(User user) throws SQLException;
	
}
