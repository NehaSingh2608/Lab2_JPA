package com.cg.ems.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="book_master")
public class Book 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ISBN_code",length=10)
	private int ISBNCode;
	@Column(name="book_title",length=25)
	private String bookTitle;
	@Column(name="book_price",length=10)
	private int bookPrice;
	@ManyToMany(mappedBy="authSet")
	Set<Author> authSet=new HashSet<>();
	public int getISBNCode() {
		return ISBNCode;
	}
	public void setISBNCode(int iSBNCode) {
		ISBNCode = iSBNCode;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public Set<Author> getAuthSet() {
		return authSet;
	}
	public void setAuthSet(Set<Author> authSet) {
		this.authSet = authSet;
	}
	public Book(int iSBNCode, String bookTitle, int bookPrice, Set<Author> authSet) {
		super();
		ISBNCode = iSBNCode;
		this.bookTitle = bookTitle;
		this.bookPrice = bookPrice;
		this.authSet = authSet;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Book [ISBNCode=" + ISBNCode + ", bookTitle=" + bookTitle + ", bookPrice=" + bookPrice + ", authSet="
				+ authSet + "]";
	}
	
}
