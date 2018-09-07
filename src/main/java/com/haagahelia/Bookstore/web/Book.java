/**
Project name: Bookstore
File name: Book.java
Author: Lorenzo Lamberti
Date of creation: 7 sept. 2018
*/
package com.haagahelia.Bookstore.web;


public class Book {
	
	private String title;
	private String author;
	private int year;
	private String isbn;
	private double price;
	
	Book(String title, String author, int year, String isbn, double price)
	{
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}