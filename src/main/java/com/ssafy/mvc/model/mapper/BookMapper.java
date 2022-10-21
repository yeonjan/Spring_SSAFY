package com.ssafy.mvc.model.mapper;

import java.sql.SQLException;
import java.util.List;


import com.ssafy.mvc.dto.Book;
import com.ssafy.mvc.dto.FileInfo;

public interface BookMapper {
	/**
	 * 책 목록 전체 조회
	 */
	
	List<Book> selectAll() throws SQLException;
	void insertBook(Book book) throws SQLException;
	void insertFileInfo(Book book) throws SQLException;

}
