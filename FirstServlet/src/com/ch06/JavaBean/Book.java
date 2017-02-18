package com.ch06.JavaBean;

public class Book {
	private String isbn;
	private String name;
	public Book(){
		
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
