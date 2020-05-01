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
	//商品id
	private int cid;
	//商品类别
	private String category;
	//商品名称
	private String cname;
	//最小价
	private int minprice;
	//最大价
	private int maxprice;
	
	

	public String execute() throws Exception {
		books=service.findAll();
		System.out.println(books);
		return "success";
	}
	public String check(){
		
		System.out.println("++++++++++++++++++"+maxprice+minprice+cname+cid+category);
		String sql="from Product";
		books=service.check(sql);
		
		return "check";
	}
	
	
	
	
	
	
	
	
	
	public List<Product> getBooks() {
		return books;
	}

	public void setBooks(List<Product> books) {
		this.books = books;
	}
	public ProductService getService() {
		return service;
	}
	public void setService(ProductService service) {
		this.service = service;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getMinprice() {
		return minprice;
	}
	public void setMinprice(int minprice) {
		this.minprice = minprice;
	}
	public int getMaxprice() {
		return maxprice;
	}
	public void setMaxprice(int maxprice) {
		this.maxprice = maxprice;
	}
	
}
