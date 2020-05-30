/**
 * 
 */
package com.bookshop.service;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookshop.dao.OrderDao;
import com.bookshop.dao.ProductDao;
import com.bookshop.model.Order;
import com.bookshop.model.OrderItem;
import com.bookshop.model.Product;
import com.bookshop.utils.PageResults;

/**
 * @author 张家宝
 * @data 2020年4月29日 下午5:55:48
 * @describe 
 */
@Transactional

@Service("orderService")
public class OrderService{


	@Resource
	private OrderDao orderDao;
	@Resource
	private OrderItemDao orderItemDao;
	
	public void submitOrder(Order order){
		orderDao.addOrder(order);
	}

	public int getOrderMaxId() {
		// TODO Auto-generated method stub
		return orderDao.getOrderMaxId();
	}

	public void addOrderItem(OrderItem orderItem) {
		orderItemDao.addOrderItem(orderItem);
		
	}

	public int getOrderId(String user_id) {
		
		return orderItemDao.getOrderId(user_id);
	}

	public Order getOrder(int id) {
		
		return orderDao.getOrderById(id);
		// TODO Auto-generated method stub
		
	}

	public void updataOrder(Order order) {
		orderDao.updataOrder(order);
		
	}

	public List<Order> getOrders(Integer id) {
		return orderDao.getOrdersByid(id);
		
	}

	public void delOrder(int id) {
		orderDao.delOrderById(id);
		
	}
}
