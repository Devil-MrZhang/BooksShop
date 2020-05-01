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
	//按条件查询
	public List<Product> check(String sql); 
	/**
	 * 
	 *@date 2020年5月1日
	  @describe 删除对应id的书
	 */
	public void delBook(int id);
	/**
	 * 
	 *@date 2020年5月1日
	  @describe 删除选中的书
	 */
	public void delAll(String[] ids);
	
}	
