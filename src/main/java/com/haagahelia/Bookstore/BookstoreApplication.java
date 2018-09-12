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


@SpringBootApplication
public class BookstoreApplication {
	
	@Autowired
	private BookStoreRepository repository;
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookStoreRepository repository) {
		return (args) -> {
			
			repository.save(new Book("Anna Karenina", "Leo Tolstoy", 1960, "817525766-0", 25.6));
			repository.save(new Book("Madame Bovary", "Gustave Flaubert", 1970, "817525766-0", 25.6));
			repository.save(new Book("Moby-dick", "George Eliot", 1960, "817525766-0", 25.6));
			
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
	
	public void findByTitle(String title) {
		List<Book> books = repository.findByTitle(title);
	}
}
