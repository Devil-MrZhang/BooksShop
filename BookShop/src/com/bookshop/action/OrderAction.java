package com.bookshop.action;

import java.util.List;
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
import com.bookshop.model.User;
import com.bookshop.service.OrderService;
import com.bookshop.service.ProductService;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.xml.internal.bind.v2.model.core.ID;
@Controller
@Scope("prototype")
public class OrderAction extends ActionSupport {
	@Resource
	private OrderService orderService; ;
	
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private HttpSession session;
	
	private Order order;
	private List<Order> orderlist;
	
	public OrderAction() {
		 req=ServletActionContext.getRequest();
		resp=ServletActionContext.getResponse();
		session=req.getSession();
		
	}
	
	public String isLogin(){
		User user = (User) session.getAttribute("user");
	
		if (user==null) {
			return "login";
		}else{
			System.out.println("*************"+user.getUsername());
			return "order";
		}
		
	}
	
	public String submitOrder(){
		System.out.println(order);
		orderService.submitOrder(order);
		int orderMaxId=orderService.getOrderMaxId();
		Map<Product, String> cart = (Map<Product, String>) session.getAttribute("cart");
		
		if (cart!=null) {
			for(Product product:cart.keySet()){
			
				int num = Integer.parseInt(cart.get(product));
				OrderItem orderItem=new OrderItem();
				orderItem.setBuynum(num);
				orderItem.setOrder_id(orderMaxId);
				orderItem.setProduct_id(product.getId());
			
				orderService.addOrderItem(orderItem);
				}
			
			
			User user =  (User) session.getAttribute("user");
			int orderId=orderService.getOrderId(user.getId()+"");
			float money=0;
			for(Product product:cart.keySet()){
					Double price = product.getPrice();
					int pnum=Integer.parseInt(cart.get(product));
					money+=price*pnum;
				}
			
			req.setAttribute("orderId", orderId);
			req.setAttribute("money", money+"");
			
			
		}
		
		
		return "submit";
	}
	
	public String paySuc() {
		User user =  (User) session.getAttribute("user");
		int orderId=orderService.getOrderId(user.getId()+"");
		 order = orderService.getOrder(orderId);
		System.out.println(order);
		order.setPayState(1);
		orderService.updataOrder(order);
		return "paySuc";
		
	}
	
	public String delOrder() {
		int id=Integer.parseInt(req.getParameter("orderId"));
		orderService.delOrder(id);
		return "delOrder";
	}
	
	public String getOrders(){
		User user =  (User) session.getAttribute("user");
		orderlist=orderService.getOrders(user.getId());
		System.out.println(orderlist.size()+"*****************");
		return "orderlist";
	}
	

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Order> getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(List<Order> orderlist) {
		this.orderlist = orderlist;
	}



	

	
	
}
