package com.altunin.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.altunin.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@GetMapping("/booklist")
	public String returnBooklist(Model model) {
		model.addAttribute("bookList", repository.findAll());
		return "listpage";
	}

}
