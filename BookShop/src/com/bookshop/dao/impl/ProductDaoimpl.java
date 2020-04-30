/**
 * 
 */
package com.bookshop.dao.impl;

import org.springframework.stereotype.Repository;

import com.bookshop.dao.ProductDao;
import com.bookshop.model.User;

/**
 * @author 张家宝
 * @data 2020年4月29日 下午5:53:15
 * @describe 
 */
@Repository("userDao")
public class ProductDaoimpl extends BaseHibernateDAO<User> implements ProductDao {

	

}
