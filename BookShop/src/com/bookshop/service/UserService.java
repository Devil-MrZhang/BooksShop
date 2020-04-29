/**
 * 
 */
package com.bookshop.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookshop.dao.UserDao;
import com.bookshop.model.User;

/**
 * @author 张家宝
 * @data 2020年4月29日 下午5:55:48
 * @describe 
 */
@Transactional
@Service

public class UserService {
	@Resource
	private UserDao userDao;
	
	public void add(User user) {
		userDao.add(user);
	}
}
