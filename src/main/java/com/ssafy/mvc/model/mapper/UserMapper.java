package com.ssafy.mvc.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.mvc.dto.User;

@Mapper
public interface UserMapper {

	//유저 정보 조회
	User selectById(User user) throws SQLException;
	
}
