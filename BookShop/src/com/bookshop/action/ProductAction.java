/**
 * 
 */
package com.bookshop.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
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
	
	
	private Product productInfo;
	
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private HttpSession session;
	
	public ProductAction() {
		 req=ServletActionContext.getRequest();
		resp=ServletActionContext.getResponse();
		session=req.getSession();
		
	}
	
	
	
	
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
	
	
	public String productInfo(){
		System.out.println("0000000000000000"+productInfo);
		
		return "productInfo";
	}
	
	public Product getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(Product productInfo) {
		this.productInfo = productInfo;
	}
	
	public String addCart(){
		String id=req.getParameter("id");
		Product product = productService.getProductById(Integer.parseInt(id));
		
		Map<Product, String> cart = (Map<Product, String>) session.getAttribute("cart");
		int num = 1;
	
		if(cart==null){
			cart = new HashMap<Product, String>();
			
		}
		
		if(cart.containsKey(product)){
			num=Integer.parseInt(cart.get(product))+1;
		}

		cart.put(product, num+"");
		session.setAttribute("cart", cart);
		System.out.println(product+"++++++++++++"+num);
	
		return "addCart";
	}
	
	public String changeNum(){
		String id = req.getParameter("id");
		String num = req.getParameter("num");
	
		Product p = new Product();
		p.setId(Integer.parseInt(id));
		
		
		Map<Product, String> cart = (Map<Product, String>) session.getAttribute("cart");
	
		if("0".equals(num)){
			cart.remove(p);
		}

		if(cart.containsKey(p)){
			cart.put(p, num);
		}
		
		return "cart";
	
	}
	

	
	
}
