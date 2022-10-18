package com.ssafy.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mvc.dto.Book;
import com.ssafy.mvc.model.dao.BookDao;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookDao bookDao;

	@Override
	public List<Book> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return bookDao.selectAll();
	}
	
	
}
