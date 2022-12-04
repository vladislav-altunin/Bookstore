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
import com.altunin.Bookstore.domain.User;
import com.altunin.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	@Autowired
	private BookRepository repository;

	@Autowired
	CategoryRepository crepository;
	
	@Autowired
	private UserRepository urepository;

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
			
			repository.save(new Book("Ernest Hemingway", "1232323-21", "A Farewell to Arms", 1929, 80, cat1));
			repository.save(new Book("George Orwell", "2212343-5", "Animal Farm", 1945, 100, cat2));

			//Save some users to the UserRepository
			//Password: "password"
			urepository.save(new User("patterson", "$2a$10$ONzQg6YLsKL5r5f410aFMOT2HffVKHm7vaXoc2GBBtAVzgqBuAbFy", "vlad.altunin@gmail.com", "ADMIN"));
			urepository.save(new User("gutafor", "$2a$10$/pXopXkHxH7y.68CpwnnwOKZ7CT8c.xD0oAHVSMdkHBJ6WaVdHgAa", "katerina.gutovskaja@gmail.com", "ADMIN"));
			urepository.save(new User("rostek", "$2a$10$I.TXVGcqao.Zi2gN5izsKeMFZBJwKiFBGK7fYi9/SWxPRNmPf8xTi", "rostik.petrenko@gmail.com", "USER"));
		};
	}

}
