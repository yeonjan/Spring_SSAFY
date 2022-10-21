package com.ssafy.mvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.mvc.ApplicationContextHolder;
import com.ssafy.mvc.model.service.BookService;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Slf4j
public class HomeController {

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		List<ApplicationContext> list = ApplicationContextHolder.list;
		for (ApplicationContext a : list) {
			log.debug("ApplicationContext 정보: {}", a.toString());
			String[] beanNames = a.getBeanDefinitionNames();
			for (int i = 0; i < beanNames.length; i++) {
				//log.debug("{}번 빈 이름 : {}",i,beanNames[i]);
				
			}
			BookService b =  (BookService) a.getBean("bookServiceImpl");
	        log.debug(b.toString());
		}

		log.debug("Welcome home! The client locale is {}.", locale);

		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

}
