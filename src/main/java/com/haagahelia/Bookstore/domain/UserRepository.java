/**
Project name: Bookstore
File name: UserRepository.java
Author: Lorenzo Lamberti
Date of creation: 25 oct. 2018
*/
package com.haagahelia.Bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}