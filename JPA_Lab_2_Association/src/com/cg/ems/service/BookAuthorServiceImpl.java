package com.cg.ems.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.ems.dao.BookAuthorDAO;
import com.cg.ems.dao.BookAuthorDAOImpl;
import com.cg.ems.dto.Author;
import com.cg.ems.dto.Book;

public class BookAuthorServiceImpl implements BookAuthorService{
	BookAuthorDAO badao;
	public BookAuthorServiceImpl()
	{
		badao=new BookAuthorDAOImpl();
	}
	@Override
	public Author addAuthorDetails(Author auth) {
		
		return badao.addAuthorDetails(auth);
	}

	@Override
	public Book addBookDetails(Book book) {
		
		return badao.addBookDetails(book);
	}

	@Override
	public ArrayList<Book> fetchAllBook() {
		
		return badao.fetchAllBook();
	}

	@Override
	public Book fetchbyAuthor(String authName) {
	
		return badao.fetchbyAuthor(authName);
	}

	@Override
	public Book fetchByPriceRange(int min,int max) {
		return badao.fetchByPriceRange(min,max);
	}

	@Override
	public Author fetchById(int ISBNCode) {
		
		return badao.fetchById(ISBNCode);
	}

}
