/**
 * 
 */
package com.bookshop.dao;

import java.util.List;

import com.bookshop.model.Product;
import com.bookshop.utils.PageResults;

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

		
	public Product add(Product p);
	
	public Product update(Product p);
	
	public Product getProductById(int id);

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
	/**
	 * 
	 *@date 2020年5月5日
	  @describe 搜索框
	 */
	public Product findProName(String name);
	/**
	 * 分页获取全部商品
	 *@author 汪龙炎
	 * @param hql
	 * @param pageNo当前页面
	 * @param pageSize一页几个
	 * @return
	 * @date  2020年5月6日  
	 * @parameter
	 */
	public PageResults<Product> findPageByFetchedHql(String hql,
			int pageNo, int pageSize); 
	/**
	 * 分页获取分类商品
	 *@author 汪龙炎
	 * @param hql
	 * @param pageNo当前页面
	 * @param pageSize一页几个
	 * @return
	 * @date  2020年5月6日  
	 * @parameter
	 */
	public PageResults<Product> findPageByCategory(String hql,
			int pageNo, int pageSize,String category); 
	
}	
