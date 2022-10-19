package com.ssafy.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.mvc.dto.Book;
import com.ssafy.mvc.dto.Book2;

public interface BookService {
	
	List<Book> selectAll() throws SQLException;
	void saveBook(Book2 book) throws SQLException;

}
