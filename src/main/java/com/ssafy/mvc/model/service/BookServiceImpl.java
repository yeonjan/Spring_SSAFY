package com.ssafy.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mvc.dto.Book;
import com.ssafy.mvc.dto.Book2;
import com.ssafy.mvc.model.mapper.BookMapper;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookMapper bookMapper;

	@Override
	public List<Book> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		
		return bookMapper.selectAll();
	}

	@Override
	public void saveBook(Book2 book) throws SQLException {
		//bookMapper.saveBook(book);

	}

}
