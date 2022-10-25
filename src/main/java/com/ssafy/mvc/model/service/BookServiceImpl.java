package com.ssafy.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.mvc.dto.Book;
import com.ssafy.mvc.dto.FileInfo;
import com.ssafy.mvc.dto.Book;
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
	@Transactional
	public void insert(Book book) throws SQLException {
		bookMapper.insertBook(book);
		
		FileInfo fileInfo=book.getFileInfo();
		if (fileInfo!=null) {
			bookMapper.insertFileInfo(book);
			
		}

	}

}
