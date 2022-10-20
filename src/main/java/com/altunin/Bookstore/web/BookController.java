package com.altunin.Bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.altunin.Bookstore.domain.Book;
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

	@GetMapping("/delete/{bookId}")
	public String deleteBook(@PathVariable("bookId") long bookId) {
		// System.out.println();
		repository.deleteById(bookId);
		return "redirect:/booklist";
	}

	@GetMapping("/add")
	public String addBook(Model model) {
		model.addAttribute("newBook", new Book());
		return "addbook";
	}

	@PostMapping("/submit")
	public String addBook(@ModelAttribute Book newBook, Model model) {
		repository.save(newBook);
		return "redirect:/booklist";
	}

	@GetMapping("/edit/{bookId}")
	public String editBook(@PathVariable("bookId") long bookId, Model model) {
		model.addAttribute("editThisBook", repository.findById(bookId));
		model.addAttribute("bookId", bookId);
		return "editbook";
	}

}
