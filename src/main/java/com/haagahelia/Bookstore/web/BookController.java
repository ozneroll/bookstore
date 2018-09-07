/**
Project name: Bookstore
File name: BookController.java
Author: Lorenzo Lamberti
Date of creation: 31 août 2018
*/
package com.haagahelia.Bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

	@GetMapping("/index")
	public String index() {
		return "index";
	}
}

