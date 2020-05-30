package com.bookshop.dao.impl;

import org.springframework.stereotype.Repository;

import com.bookshop.dao.OrderDao;
import com.bookshop.dao.OrderItemDao;
import com.bookshop.model.Order;
import com.bookshop.model.OrderItem;
@Repository("orderItemDao")
public class OrderItemDaoimpl  extends BaseHibernateDAO<OrderItem>  implements OrderItemDao{

	@Override
	public void addOrderItem(OrderItem orderItem) {
		saveOrUpdate(orderItem);
		
	}

	@Override
	public int getOrderId(String user_id) {
		
		return super.getOrderId(user_id);
	}

	





}
