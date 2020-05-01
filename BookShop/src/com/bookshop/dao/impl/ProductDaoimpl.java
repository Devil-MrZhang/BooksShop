/**
 * 
 */
package com.bookshop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bookshop.dao.ProductDao;
import com.bookshop.model.Product;

/**
 * @author 张家宝
 * @data 2020年4月29日 下午5:53:15
 * @describe 
 */
@Repository("productDao")
public class ProductDaoimpl extends BaseHibernateDAO<Product> implements ProductDao {

	
	@Override
	public List<Product> findAll() {
	
		return getAll()	;
	}

	@Override
	public void add(Product p) {
		// TODO Auto-generated method stub
		saveOrUpdate(p);
	}

	@Override
	public void update(Product p) {
		// TODO Auto-generated method stub
		saveOrUpdate(p);
	}
	public List<Product> check(String sql) {
		// TODO Auto-generated method stub
		return super.find(sql);
	}


	@Override
	public void delBook(int id) {
		super.del(id);
		
	}
	@Override
	public void delAll(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			int id=Integer.parseInt(ids[i]);
			super.del(id);
		}
		
	}



	

}
