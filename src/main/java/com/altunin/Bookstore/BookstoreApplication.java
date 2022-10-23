package com.altunin.Bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.altunin.Bookstore.domain.Book;
import com.altunin.Bookstore.domain.BookRepository;
import com.altunin.Bookstore.domain.Category;
import com.altunin.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	@Autowired
	private BookRepository repository;

	@Autowired
	CategoryRepository crepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			
			Category cat1 = new Category("Science");
			Category cat2 = new Category("Fiction");
			Category cat3 = new Category("Arts");
			
			crepository.save(cat1);
			crepository.save(cat2);
			crepository.save(cat3);
			
			repository.save(new Book("Ernest Hemingway", "1232323-21", "A Farewell to Arms", 1929, 100, cat1));
			repository.save(new Book("George Orwell", "2212343-5", "Animal Farm", 1945, 100, cat2));
		};
	}

}
