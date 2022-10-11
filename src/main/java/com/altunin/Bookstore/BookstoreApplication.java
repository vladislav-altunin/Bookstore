package com.altunin.Bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.altunin.Bookstore.domain.Book;
import com.altunin.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	@Autowired
	private BookRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			repository.save(new Book("Ernest Hemingway", "1232323-21", "A Farewell to Arms", 1929, 100));
			repository.save(new Book("George Orwell", "2212343-5", "Animal Farm", 1945, 100));
			System.out.println("Repo is here " + repository.findById((long) 1).get());
		};
	}

}
