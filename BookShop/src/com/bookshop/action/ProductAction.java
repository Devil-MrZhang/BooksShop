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
		
		
		switch (productInfo.getCategory()) {
		case "1":
			productInfo.setCategory("文学");
			break;
		case "2":
			productInfo.setCategory("生活");
			break;
		case "3":
			productInfo.setCategory("计算机");
			break;
		case "4":
			productInfo.setCategory("外语");
			break;
		case "5":
			productInfo.setCategory("经营");
			break;
		case "6":
			productInfo.setCategory("励志");
			break;
		case "7":
			productInfo.setCategory("社科");
			break;
		case "8":
			productInfo.setCategory("学术");
			break;
		case "9":
			productInfo.setCategory("少儿");
			break;
		case "10":
			productInfo.setCategory("艺术");
			break;
		case "11":
			productInfo.setCategory("原版");
			break;
		case "12":
			productInfo.setCategory("科技");
			break;
		case "13":
			productInfo.setCategory("考试");
			break;
		case "14":
			productInfo.setCategory("生活百科");
			break;

		}
		
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
		switch (product.getCategory()) {
		case "1":
			product.setCategory("文学");
			break;
		case "2":
			product.setCategory("生活");
			break;
		case "3":
			product.setCategory("计算机");
			break;
		case "4":
			product.setCategory("外语");
			break;
		case "5":
			product.setCategory("经营");
			break;
		case "6":
			product.setCategory("励志");
			break;
		case "7":
			product.setCategory("社科");
			break;
		case "8":
			product.setCategory("学术");
			break;
		case "9":
			product.setCategory("少儿");
			break;
		case "10":
			product.setCategory("艺术");
			break;
		case "11":
			product.setCategory("原版");
			break;
		case "12":
			product.setCategory("科技");
			break;
		case "13":
			product.setCategory("考试");
			break;
		case "14":
			product.setCategory("生活百科");
			break;

		}

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
