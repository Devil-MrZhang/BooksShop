package com.bookshop.dao.impl;

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

}
