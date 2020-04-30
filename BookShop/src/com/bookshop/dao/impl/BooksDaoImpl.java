package com.bookshop.dao.impl;

import org.springframework.stereotype.Repository;

import com.bookshop.dao.BooksDao;
import com.bookshop.model.Books;

@Repository("booksDao")
public class BooksDaoImpl extends BaseHibernateDAO<Books> implements BooksDao {

	@Override
	public void add(Books b) {
		// TODO Auto-generated method stub
		super.saveOrUpdate(b);
	}

	@Override
	public void update(Books b) {
		// TODO Auto-generated method stub
		super.saveOrUpdate(b);
	}

	@Override
	public void del(int id) {
		// TODO Auto-generated method stub
		super.del(id);
	}

}
