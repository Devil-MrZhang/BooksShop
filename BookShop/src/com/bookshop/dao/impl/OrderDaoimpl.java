package com.bookshop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bookshop.dao.OrderDao;
import com.bookshop.model.Order;
import com.bookshop.model.OrderItem;
@Repository("orderDao")
public class OrderDaoimpl  extends BaseHibernateDAO<Order>  implements OrderDao{

	@Override
	public void addOrder(Order order) {
		
		saveOrUpdate(order);
	}

	@Override
	public int getOrderMaxId() {
		
		return getMaxId("SELECT MAX(id) FROM t_orders");
	}

	@Override
	public Order getOrderById(int id) {
		
		return get(id);
	}

	@Override
	public void updataOrder(Order order) {
		saveOrUpdate(order);
		
	}

	@Override
	public List<Order> getOrdersByid(Integer id) {
		
		return getListByHQL("from Order where user_id=?", id);
	}

	@Override
	public void delOrderById(int id) {
		del(id);
		
	}




}
