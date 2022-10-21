package com.ssafy.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.mvc.dto.Book;
import com.ssafy.mvc.dto.Book2;
import com.ssafy.mvc.model.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/book")
@Slf4j
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("/list")
	public String showBookList(Model model) throws SQLException {
		System.out.println("/book/list getList");
		// 1. 전체 목록 도회 데이터 받아오기
		List<Book> list = bookService.selectAll();
		
		System.out.println(list);
		
		//Model로 처리한 결과를 담기
		model.addAttribute("list",list);
		log.debug(bookService.getClass().getName());
		
		// 2. view 반환
		
		return "bookList";

	}
	
	
	@GetMapping("/goRegist")
	public String regist() {
		return "regist";
	}
	
	@GetMapping("/regist")
	public ModelAndView regist(Book2 book) throws SQLException {
		bookService.saveBook(book);
		
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("redirect:/book/list");
		
		return mav;
	}
}
