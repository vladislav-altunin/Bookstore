package com.altunin.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.altunin.Bookstore.web.BookController;
import com.altunin.Bookstore.web.BookRestController;

@RunWith(SpringRunner.class)
//@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstoreApplicationTests {
	
	@Autowired
	private BookController controller;
	
	@Autowired
	private BookRestController restController;
	
	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
		assertThat(restController).isNotNull();
	}
}
