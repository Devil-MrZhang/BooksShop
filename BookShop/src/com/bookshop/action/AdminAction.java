/**
 * 
 */
package com.bookshop.action;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bookshop.model.Product;
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
	private List<Product> books;
	
	public List<Product> getBooks() {
		return books;
	}

	public void setBooks(List<Product> books) {
		this.books = books;
	}

	public String execute() throws Exception {
		books=service.findAll();
		System.out.println(books);
		return "success";
	}

}
