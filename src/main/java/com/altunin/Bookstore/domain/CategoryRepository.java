package com.altunin.Bookstore.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends CrudRepository<Category, Integer>{
	
	//Fetch by name
	Optional<Category> findByName(@Param("name") String name);

}
