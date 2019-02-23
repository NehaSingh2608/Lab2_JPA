package com.cg.ems.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.cg.ems.dto.Author;
import com.cg.ems.dto.Book;
import com.cg.ems.util.JPAUtil;


public class BookAuthorDAOImpl implements BookAuthorDAO{

	EntityManager em=null;
	  EntityTransaction et=null;
	  public BookAuthorDAOImpl()
	  {
		 em=JPAUtil.getEntityManager();
		 et=em.getTransaction();
	  }
	@Override
	public Author addAuthorDetails(Author auth) {
		et.begin();
		em.persist(auth);
		et.commit();
		return auth;
	}

	@Override
	public Book addBookDetails(Book book) {
		et.begin();
		em.persist(book);
		et.commit();
		return book;
	}

	@Override
	public ArrayList<Book> fetchAllBook() {
		String selAllQuery="Select bk from Book bk"; 		
		TypedQuery tq=em.createQuery(selAllQuery, Author.class);
		ArrayList<Book> booklist=(ArrayList) tq.getResultList();
				return booklist;
	}

	@Override
	public Book fetchbyAuthor(String authName) {
		Book author=em.find(Book.class,authName);
		return author;
	}

	@Override
	public Book fetchByPriceRange(int min,int max) {
	String selQry="Select bk from Book bk where bookPrice BETWEEN 500  AND 1000";
		TypedQuery tq=em.createQuery(selQry,Book.class);
      List<Book> list= tq.getResultList();
		
	return null;
	}

	@Override
	public Author fetchById(int ISBNCode) {
		Author auth=em.find(Author.class,ISBNCode);
		return auth;
	}
	

}
