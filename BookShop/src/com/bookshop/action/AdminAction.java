/**
 * 
 */
package com.bookshop.action;

import javax.annotation.Resource;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bookshop.model.User;
import com.bookshop.service.ProductService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 张家宝
 * @data 2020年4月29日 下午5:57:28
 * @describe 
 */
@Controller
@Scope("prototype")
public class AdminAction extends ActionSupport {
	@Resource
	private ProductService service;
	
	public String execute() throws Exception {
	
		
		return "success";
	}

}
