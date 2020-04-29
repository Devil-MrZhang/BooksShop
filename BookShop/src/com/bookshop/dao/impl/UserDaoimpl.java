/**
 * 
 */
package com.bookshop.dao.impl;

import org.springframework.stereotype.Repository;

import com.bookshop.dao.UserDao;
import com.bookshop.model.User;

/**
 * @author 张家宝
 * @data 2020年4月29日 下午5:53:15
 * @describe 
 */
@Repository("userDao")
public class UserDaoimpl extends BaseHibernateDAO<User> implements UserDao {

	@Override
	public void add(User user) {
		
		saveOrUpdate(user);
	}

}
