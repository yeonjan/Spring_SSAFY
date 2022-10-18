package com.ssafy.mvc.model.dao;


import java.sql.SQLException;
import java.util.List;

import com.ssafy.mvc.dto.Book;

public interface BookDao {
	List<Book> selectAll() throws SQLException;

}
