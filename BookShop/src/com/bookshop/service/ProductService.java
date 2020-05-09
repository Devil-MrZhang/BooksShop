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
import com.bookshop.utils.PageResults;

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
	/**
	 * 
	 *@date 2020年5月5日
	  @describe 搜索框
	 */
	public Product findProName(String name){
		
			return productDao.findProName(name);
		}
	/**
     * 全部商品分页
     *@author 汪龙炎
     * @param pageNo当前页码
     * @return
     * @date  2020年5月6日  
     * @parameter
     */
	public PageResults<Product> findPageUser(int pageNo){
		return productDao.findPageByFetchedHql("from Product", pageNo, 5);
	}
	/**
	 * 分类商品分页
	 */
	public PageResults<Product> findPageProduct(int pageNo,String category){
		return productDao.findPageByCategory("from Product p where p.category = ?", pageNo, 5,category); 
	}
}
