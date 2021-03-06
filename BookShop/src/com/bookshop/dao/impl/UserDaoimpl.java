/**
 * 
 */
package com.bookshop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bookshop.dao.ProductDao;
import com.bookshop.dao.UserDao;
import com.bookshop.model.Product;
import com.bookshop.model.User;

/**
 * @author 张家宝
 * @data 2020年4月29日 下午5:53:15
 * @describe 
 */
@Repository("userDao")
public class UserDaoimpl extends BaseHibernateDAO<User> implements  UserDao{

	@Override
	public void addUser(User user) {
		super.saveOrUpdate(user);
		
	}

	@Override
	public User cha(int i) {
		// TODO Auto-generated method stub
		return get(i);
	}

	
	
	/*
	 * 登录验证
	 * */
	@Override
	public User login(String hql, String username, String password) {
		
		return super.getByHQL(hql, username,password);
	}


	@Override
	public void modiry(User user) {
		// TODO Auto-generated method stub
		super.saveOrUpdate(user);
	}

	

}
