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

	

}
