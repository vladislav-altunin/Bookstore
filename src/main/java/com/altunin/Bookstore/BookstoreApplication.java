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
			repository.save(new Book("Hinkula, Juha", "978-178913-808-5", "Hands-on Full Stack Development with Spring Boot and React", 2018, 100));
		};
	}

}
