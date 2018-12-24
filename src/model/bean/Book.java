package model.bean;

import java.util.Date;

public class Book {
	private int idBook;
	private String name;
	private Date dateAdded;
	
	public Book() {
		super();
	}
	
	public Book(int idBook, String name, Date dateAdded) {
		super();
		this.idBook = idBook;
		this.name = name;
		this.dateAdded = dateAdded;
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
