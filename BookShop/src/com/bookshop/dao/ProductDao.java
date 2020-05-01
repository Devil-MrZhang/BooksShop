/**
 * 
 */
package com.bookshop.dao;

import java.util.List;

import com.bookshop.model.Product;

/**
 * @author 张家宝
 * @data 2020年4月28日 上午10:54:08
 * @describe 
 */
public interface ProductDao {
	/**
	 * 
	 *@date 2020年4月30日
	  @describe 查询所有产品
	 */
	public List<Product> findAll(); 

		
	public void add(Product p);
	
	public void update(Product p);

	//按条件查询
	public List<Product> check(String sql); 

	
}
