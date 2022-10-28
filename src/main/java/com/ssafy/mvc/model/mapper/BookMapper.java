package com.ssafy.mvc.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.mvc.dto.Book;
import com.ssafy.mvc.dto.FileInfo;

//@Mapper -> root xml에 컴포넌트 스캔을 했으므로 애노테이션을 붙일 필요가 없다
public interface BookMapper {
	/**
	 * 책 목록 전체 조회
	 */
	
	List<Book> selectAll() throws SQLException;
	void insertBook(Book book) throws SQLException;
	void insertFileInfo(Book book) throws SQLException;

}
