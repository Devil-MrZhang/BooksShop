/**
 * 
 */
package com.bookshop.service;

import java.util.Date;
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
@Service

public class ProductService extends ActionSupport{

public class ProductService {

	@Resource
	private ProductDao productDao;
	
	public List<Product> findAll() {
		
		return productDao.findAll();
	}
	//按条件查询
	public List<Product> check(String sql){
		return productDao.check(sql);
		
	}
	
	public void addBooks(Integer id,String name,Double price,String img_url,Integer pnum,String category,String description){
		p.setId(id);
		p.setName(name);
		p.setPrice(price);
		p.setImg_url(img_url);
		p.setPnum(pnum);
		p.setCategory(category);
		p.setDescription(description);
		productDao.add(p);
		
		
	}
}
