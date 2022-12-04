package com.altunin.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.altunin.Bookstore.domain.Book;
import com.altunin.Bookstore.domain.BookRepository;
import com.altunin.Bookstore.domain.Category;
import com.altunin.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;

	@Autowired
	CategoryRepository crepository;
	
	@GetMapping("/booklist")
	public String returnBooklist(Model model) {
		model.addAttribute("bookList", repository.findAll());
		return "listpage";
	}

	@GetMapping("/delete/{bookId}")
	public String deleteBook(@PathVariable("bookId") Integer bookId) {
		// System.out.println();
		repository.deleteById(bookId);
		return "redirect:/booklist";
	}

	@GetMapping("/add")
	public String addBook(@ModelAttribute Book newBook, Model model) {
		model.addAttribute("newBook", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}

	@PostMapping("/submit")
	public String addBook(@ModelAttribute Book newBook, @ModelAttribute Category category, Model model) {
		repository.save(newBook);
		return "redirect:/booklist";
	}

	@GetMapping("/edit/{bookId}")
	public String editBook(@PathVariable("bookId") Integer bookId, Model model) {
		model.addAttribute("editThisBook", repository.findById(bookId));
		model.addAttribute("newBook", new Book()); // might delete later incl @ModelAttribute
		model.addAttribute("bookId", bookId);
		model.addAttribute("categories", crepository.findAll());
		return "editbook";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

}
