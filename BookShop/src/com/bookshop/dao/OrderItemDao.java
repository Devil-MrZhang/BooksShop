package com.bookshop.dao;

import com.bookshop.model.Order;
import com.bookshop.model.OrderItem;

public interface OrderItemDao {

	public void addOrderItem(OrderItem orderItem);

	public int getOrderId(String user_id);
}
