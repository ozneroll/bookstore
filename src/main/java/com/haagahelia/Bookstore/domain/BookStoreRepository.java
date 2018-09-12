/**
Project name: Bookstore
File name: BookStoreRepository.java
Author: Lorenzo Lamberti
Date of creation: 9 sept. 2018
*/
package com.haagahelia.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface BookStoreRepository extends CrudRepository<Book, Long> {
	
	List<Book> findByTitle(String title);

}
