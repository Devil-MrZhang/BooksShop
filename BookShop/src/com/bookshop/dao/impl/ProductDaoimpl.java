/**
 * 
 */
package com.bookshop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bookshop.dao.ProductDao;
import com.bookshop.model.Product;
import com.bookshop.utils.PageResults;

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
	public Product add(Product p) {
		return saveOrUpdate(p);
	}

	@Override
	public Product update(Product p) {
		
		return saveOrUpdate(p);
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

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return super.get(id);
	}


	/**
	 * 
	 *@date 2020年5月5日
	  @describe 搜索框
	 */
	@Override
	public PageResults<Product> findProName(String hql, int pageNo, int pageSize, String names) {
		// TODO Auto-generated method stub
		return super.findPageByFetchedHql(hql, null, pageNo, pageSize, names);
	}
	/**
	 * 全部商品分页 	 
	 */
	@Override
	public PageResults<Product> findPageByFetchedHql(String hql, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return super.findPageByFetchedHql(hql, null,pageNo, pageSize);
	}

	
	/**
	 * 分类商品分页 	 
	 */
	@Override
	public PageResults<Product> findPageByCategory(String hql, int pageNo, int pageSize,String category) {
		// TODO Auto-generated method stub
		return super.findPageByFetchedHql(hql, null, pageNo, pageSize, category);
	}

	




	

}
