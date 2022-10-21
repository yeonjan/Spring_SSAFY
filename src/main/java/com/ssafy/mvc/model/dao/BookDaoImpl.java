package com.ssafy.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.mvc.dto.Book;
import com.ssafy.mvc.dto.Book2;

@Repository
public class BookDaoImpl implements BookDao {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<Book> selectAll() throws SQLException {
		return sqlSession.selectList("BookMapper.selectAll");
	}

	@Override
	public void saveBook(Book2 book) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	
	
//	@Autowired
//	DataSource ds;
//
//	@Override
//	public List<Book> selectAll() throws SQLException {
//		// TODO Auto-generated method stub
//		
//		String sql ="select isbn,title,author,price from book";
//		
//		Connection conn =null;
//		PreparedStatement pstmt =null;
//		ResultSet rs =null;
//		
//		try {
//			conn=ds.getConnection();
//			pstmt =conn.prepareStatement(sql);
//			
//			rs=pstmt.executeQuery();
//			List<Book> list =new ArrayList<Book>();
//			while(rs.next()) {
//	            Book book = new Book();
//	            book.setIsbn(rs.getString(1));
//	            book.setTitle(rs.getString(2));
//	            book.setAuthor(rs.getString(3));
//	            book.setPrice(rs.getInt(4));
//	            list.add(book);
//	        }
//			return list;
//			
//		} finally {
//			if (rs!=null) rs.close();
//			if (pstmt!=null) pstmt.close();
//			if (conn!=null) conn.close();
//
//		}
//	}
//	
//	@Override
//	public void saveBook(Book2 book) throws SQLException {
//		String sql = "insert into book(isbn,title,author,price) values (?, ?, ?, ?);";
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//
//
//		try {
//			conn = ds.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, book.getIsbn());
//			pstmt.setString(2, book.getTitle());
//			pstmt.setString(3, book.getAuthor());
//			pstmt.setInt(4,book.getPrice());
//			int cnt = pstmt.executeUpdate();
//
//
//		} finally {
//
//			if (pstmt != null)
//				pstmt.close();
//			if (conn != null)
//				conn.close();
//		}
//
//	}

}
