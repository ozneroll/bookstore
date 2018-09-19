/**
Project name: Bookstore
File name: CategoryRepository.java
Author: Lorenzo Lamberti
Date of creation: 19 sept. 2018
*/
package com.haagahelia.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	List<Category> findByName(String name);

}
