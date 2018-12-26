package model.bean;

import java.util.Date;

public class Book {
	private int idBook;
	private String name;
	private Date dateAdded;
	private String author;
	
	public Book() {
		super();
	}
	
	public Book(int idBook, String name, Date dateAdded, String author) {
		super();
		this.idBook = idBook;
		this.name = name;
		this.dateAdded = dateAdded;
		this.author = author;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getIdBook() {
		return idBook;
	}
	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
}
