package com.altunin.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

//import java.security.cert.Extension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.altunin.Bookstore.domain.Book;
import com.altunin.Bookstore.domain.BookRepository;
import com.altunin.Bookstore.domain.CategoryRepository;

//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
//@DataJpaTest
@SpringBootTest
public class BookRepositoryTest {
//	@Autowired
//	private TestEntityManager entityManager;
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	//Create book
	@Test
	public void createBook() throws Exception {
		Book book = new Book("William Shakespeare", "ISBN-9780192814517", "Othello", 1604, 20, crepository.findByName("Science").get());
//		entityManager.persistAndFlush(book);
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	//Delete book
	@Test
	public void deleteBook() {
		Book book = new Book("William Shakespeare", "ISBN-9780192814517", "Othello", 1604, 20, crepository.findByName("Science").get());
		repository.save(book);
//		entityManager.persistAndFlush(book);
		repository.deleteAll();
		assertThat(repository.findAll()).isEmpty();
		
	}
	
	//Find book
	@Test
	public void findBook() {
//		Book book = new Book("William Shakespeare", "ISBN-9780192814517", "Othello", 1604, 20, crepository.findByName("Science").get());
//		entityManager.persistAndFlush(book); 
//		assertThat(repository.findByTitle("Othello").get().getTitle()).isEqualTo("Othello");
		
		Optional<Book> books = repository.findByTitle("Animal Farm");
		assertThat(books.get().getAuthor()).isEqualTo("George Orwell");
	}

}
