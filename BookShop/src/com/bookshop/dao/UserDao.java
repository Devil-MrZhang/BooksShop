/**
 * 
 */
package com.bookshop.dao;

import com.bookshop.model.User;

/**
 * @author 张家宝
 * @data 2020年5月4日 下午5:16:05
 * @describe 
 */
public interface UserDao {
	/**
	 * 
	 *@date 2020年5月4日
	  @describe 添加用户
	 */
	public void addUser(User user);
	public void modiry(User user);
		
	public User cha(int i);
	
	
	/**
	 * 登录验证
	 * @param hql
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String hql,String username, String password);
}
