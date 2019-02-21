package com.wisestep.elastic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wisestep.elastic.model.Book;
import com.wisestep.elastic.service.BookServiceDao;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {

	@Autowired
	private BookServiceDao bookService;

	/**
	 * HTTP Rest API for searching Book index in Elastic Server
	 * @param text
	 * @return
	 */
	@RequestMapping("/search")
	public List<Book> searchBookForText(@RequestParam("text") String text) {
		return bookService.getBookContent(text);
	}

}
