/**
Project name: Bookstore
File name: BookController.java
Author: Lorenzo Lamberti
Date of creation: 31 août 2018
*/
package com.haagahelia.Bookstore.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.h2.util.New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haagahelia.Bookstore.domain.Book;
import com.haagahelia.Bookstore.domain.BookStoreRepository;
import com.haagahelia.Bookstore.domain.CategoryRepository;


@Controller
public class BookController {
	
	@Autowired
	private BookStoreRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	

    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
	@RequestMapping("/booklist")
	public String booklist(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	// RESTful service to get all books
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) repository.findAll();
    }    

	// RESTful service to get book by id
    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
    	return repository.findById(bookId);
    }   
	
	@RequestMapping(value = "/addbook")
	public String addStudent(Model model){
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book){
		repository.save(book);
		return "redirect:booklist";
	}
	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", crepository.findAll());
		return "editbook";
	}
	
}

