/**
 * 
 */
package com.bookshop.action;

import javax.annotation.Resource;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bookshop.model.User;
import com.bookshop.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 张家宝
 * @data 2020年4月29日 下午5:57:28
 * @describe 
 */
@Controller
@Scope("prototype")
public class TestAction extends ActionSupport {
	@Resource
	private UserService service;
	
	public String execute() throws Exception {
	
		User user=new User();
		user.setName("zhansgan");
		user.setPassword("1234");
		service.add(user);
		
		return "success";
	}

}
