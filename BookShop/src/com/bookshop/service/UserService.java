/**
 * 
 */
package com.bookshop.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookshop.dao.ProductDao;
import com.bookshop.dao.UserDao;
import com.bookshop.model.Product;
import com.bookshop.model.User;

/**
 * @author 张家宝
 * @data 2020年4月29日 下午5:55:48
 * @describe 
 */
@Transactional

@Service("userService")
public class UserService{
	
	@Resource
	private UserDao userDao;
	/**
	 * 
	 *@date 2020年5月4日
	  @describe 用户注册
	 */
	public void register(User user) {
		userDao.addUser(user);
	}
	
	public User cha(int id){
		return userDao.cha(id);
	}

	
	/*
	 * 用户登录验证
	 */
	public User login(String username,String password) {
	//	String hql="from t_user e where e.username=? and e.password=?";
		return userDao.login("from User e where e.username=? and e.password=?",username,password);
		  
		
		
	}
	

	//修改用户信息
	public void modiry(User user) {
		userDao.modiry(user);
	}

}
