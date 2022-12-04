package com.altunin.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.altunin.Bookstore.domain.Category;
import com.altunin.Bookstore.domain.CategoryRepository;

//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	CategoryRepository crepository;

	// Create category
	@Test
	public void createCategory() {
		Category cat = new Category("Classics");
		entityManager.persistAndFlush(cat);
		assertThat(cat.getCategoryId()).isNotNull();
//		assertThat(crepository.findAll()).isNotEmpty();
	}

	// Delete category
	@Test
	public void deleteCategory() {
		Category cat1 = new Category("Classics");
		entityManager.persistAndFlush(cat1);

		Category cat2 = new Category("Languages");
		entityManager.persistAndFlush(cat2);

		crepository.deleteAll();
		assertThat(crepository.findAll()).isEmpty();
	}

	// Search category
	@Test
	public void findCategory() {
		Category cat = new Category("Classics");
		entityManager.persistAndFlush(cat);
		assertThat(crepository.findByName("Classics").get().getName()).isEqualTo("Classics");
	}
}
