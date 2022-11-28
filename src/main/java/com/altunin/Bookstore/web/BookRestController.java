package com.altunin.Bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.altunin.Bookstore.domain.Book;
import com.altunin.Bookstore.domain.BookRepository;

@RestController
public class BookRestController {
	@Autowired
	private BookRepository repository;

	@GetMapping("/books")
	public Iterable<Book> getBook() {
		return repository.findAll();
	}

	@GetMapping("/find/{bookId}")
	public List<Book> findById(@PathVariable("bookId") int bookId) {
		return repository.findById(bookId);
	}

}
