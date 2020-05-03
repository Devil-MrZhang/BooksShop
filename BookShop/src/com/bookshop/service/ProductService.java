/**
 * 
 */
package com.bookshop.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookshop.dao.ProductDao;
import com.bookshop.model.Product;

/**
 * @author 张家宝
 * @data 2020年4月29日 下午5:55:48
 * @describe 
 */
@Transactional

@Service("service")
public class ProductService{


	@Resource
	private ProductDao productDao;
	private Product p;
	public List<Product> findAll() {
		
		return productDao.findAll();
	}
	//按条件查询
	public List<Product> check(String sql){
		return productDao.check(sql);
		
	}
	public void delBookById(int id) {
		productDao.delBook(id);
	}
	
	public void delAllBooks(String[] ids) {
		
		productDao.delAll(ids);
		
	}
	

	public Product addBooks(Product p){
		
		
		return productDao.add(p);	
	}
	public Product updateBooks(Product p){
		
		return productDao.update(p);
	}
	
	public Product getProductById(int id){
		
		return productDao.getProductById(id);
	}
}
