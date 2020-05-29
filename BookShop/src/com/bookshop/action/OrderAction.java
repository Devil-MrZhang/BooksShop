package com.bookshop.action;

import java.util.Map;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bookshop.dao.OrderDao;
import com.bookshop.model.Order;
import com.bookshop.model.OrderItem;
import com.bookshop.model.Product;
import com.bookshop.service.OrderService;
import com.bookshop.service.ProductService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class OrderAction extends ActionSupport {
	@Resource
	private OrderService orderService; ;
	
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private HttpSession session;
	
	private Order order;
	
	public OrderAction() {
		 req=ServletActionContext.getRequest();
		resp=ServletActionContext.getResponse();
		session=req.getSession();
		
	}
	
	public String isLogin(){
		Object username = session.getAttribute("username");
		System.out.println("*************"+username);
		if (username==null) {
			return "login";
		}else{
			return "order";
		}
		
	}
	
	public String submitOrder(){
		System.out.println(order);
		orderService.submitOrder(order);
		return "submit";
	}
	

	
	
}
