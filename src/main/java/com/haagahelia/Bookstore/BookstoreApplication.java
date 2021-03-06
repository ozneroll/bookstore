package com.haagahelia.Bookstore;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.haagahelia.Bookstore.domain.Book;
import com.haagahelia.Bookstore.domain.BookStoreRepository;
import com.haagahelia.Bookstore.domain.Category;
import com.haagahelia.Bookstore.domain.CategoryRepository;
import com.haagahelia.Bookstore.domain.User;
import com.haagahelia.Bookstore.domain.UserRepository;



@SpringBootApplication
public class BookstoreApplication {
	
//	@Autowired
//	private BookStoreRepository repository;
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookStoreRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "killian@gmail.com", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "lorenzo@gmail.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			
			crepository.save(new Category("Mystery"));
			crepository.save(new Category("Drama"));
			crepository.save(new Category("Poetry"));

			brepository.save(new Book("Anna Karenina", "Leo Tolstoy", 1960, "60000258-0", 25.6, crepository.findByName("Mystery").get(0)));
			brepository.save(new Book("Madame Bovary", "Gustave Flaubert", 1970, "60000300-0", 25.6, crepository.findByName("Drama").get(0)));
			brepository.save(new Book("Moby-dick", "George Eliot", 1960, "60000800-0", 25.6, crepository.findByName("Drama").get(0)));
			
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
	
}
