/**
 * 
 */
package com.bookshop.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bookshop.model.Product;
import com.bookshop.model.User;
import com.bookshop.service.ProductService;
import com.bookshop.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.Authenticator.Success;

/**
 * @author 张家宝
 * @data 2020年5月4日 下午5:24:33
 * @describe 
 */
@Controller
@Scope("prototype")
public class ProductAction extends ActionSupport {
	private List<Product> products; 
	@Resource
	private ProductService productService;
	/**
	 * 
	 *@date 2020年5月4日
	  @describe 显示 所有商品
	 */
	public String showList() {
		
		return SUCCESS;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
	
}
