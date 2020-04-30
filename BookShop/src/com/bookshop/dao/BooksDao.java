package com.bookshop.dao;

import com.bookshop.model.Books;

public interface BooksDao {
	
	public void add(Books b);
	
	public void update(Books b);
	
	public void del(int id);
}
