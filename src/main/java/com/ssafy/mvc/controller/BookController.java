package com.ssafy.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.mvc.dto.Book;
import com.ssafy.mvc.dto.Book;
import com.ssafy.mvc.dto.FileInfo;
import com.ssafy.mvc.model.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/book")
@Slf4j
public class BookController {

	@Autowired
	ServletContext servletContext;

	@Autowired
	BookService bookService;

	@GetMapping("/list")
	public String showBookList(Model model) throws SQLException {
		System.out.println("/book/list getList");
		// 1. 전체 목록 도회 데이터 받아오기
		List<Book> list = bookService.selectAll();

		System.out.println(list);

		// Model로 처리한 결과를 담기
		model.addAttribute("list", list);
		log.debug(bookService.getClass().getName());

		// 2. view 반환

		return "bookList";

	}

	@GetMapping("/regist")
	public String regist() {
		return "regist";
	}

	@PostMapping("/regist")
	public String regist(Book book, @RequestParam MultipartFile file)
			throws SQLException, IllegalStateException, IOException {
		log.debug("책 등록 요청 수신 - 책 정보 {}", book.toString());
		log.debug("파일 존재 여부 : {}", file.isEmpty());

		if (!file.isEmpty()) {
			// 파일 정보가 있는 경우
			// 1.파일 업로드
			String path = servletContext.getRealPath("/upload");
			String today = new SimpleDateFormat("yyMMdd").format(new Date());
			File folder = new File(path + File.separator + today);
			log.debug(folder + "");
			// 해당 폴더가 없다면 만들기
			if (!folder.exists())
				folder.mkdirs();

			// 파일 업로드
			String originFile = file.getOriginalFilename(); // 원본 파일 명
			// 저장될 파일명 만들기
			String saveFile = UUID.randomUUID().toString() + originFile.substring(originFile.lastIndexOf('.'));
			// 파일 저장
			file.transferTo(new File(folder, saveFile));

			// 2.파일 데이터 DB에 저장
			FileInfo fileInfo = new FileInfo();
			fileInfo.setIsbn(book.getIsbn());
			fileInfo.setSaveFolder(today);
			fileInfo.setSaveFile(saveFile);
			fileInfo.setOriginFile(originFile);
			book.setFileInfo(fileInfo);
		}

		// 책 정보 DB에 저장
		bookService.insert(book);
		// 책 목록 화면으로 이동

		// 파일 정보가 없는 경우

		return "redirect:list";
	}
}
