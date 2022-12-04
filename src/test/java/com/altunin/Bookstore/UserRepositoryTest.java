package com.altunin.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.altunin.Bookstore.domain.User;
import com.altunin.Bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
//@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired UserRepository urepository;

	// Create book
	@Test
	public void createUser() {
		User user = new User("testUser", "ONzQg6YLsKL5r5f410aFMOT2HffVKHm7vaXoc2GBBtAVzgqBuAbFy", "test.user@gmail.fi", "ADMIN");
		entityManager.persistAndFlush(user);
		assertThat(user.getId()).isNotNull();
//		assertThat(urepository.findAll()).isNotEmpty();
	}
	
	//Delete user
	@Test
	public void deleteUser() {
		User user1 = new User("testuser1", "ONzQg6YLsKL5r5f410aFMOT2HffVKHm7vaXoc2GBBtAVzgqBuAbFy", "test.user1@gmail.fi", "ADMIN");
		entityManager.persistAndFlush(user1);
		
		User user2 = new User("testuser2", "ONzQg6YLsKL5r5f410aFMOT2HffVKHm7vaXoc2GBBtAVzgqBuAbFy", "test.user2@gmail.fi", "USER");
		entityManager.persistAndFlush(user2);
		
		urepository.deleteAll();
		assertThat(urepository.findAll()).isEmpty();
	}
	
	//Search user
	@Test
	public void findUser() {
		User user = new User("testuser", "ONzQg6YLsKL5r5f410aFMOT2HffVKHm7vaXoc2GBBtAVzgqBuAbFy", "test.user@gmail.fi", "ADMIN");
		entityManager.persistAndFlush(user);
		assertThat(urepository.findByUsername("testuser").getUsername()).isEqualTo("testuser");
	}
}
