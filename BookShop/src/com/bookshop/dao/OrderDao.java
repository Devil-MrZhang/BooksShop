package com.bookshop.dao;

import java.util.List;

import com.bookshop.model.Order;
import com.bookshop.model.OrderItem;

public interface OrderDao {

	public void addOrder(Order order);

	public int getOrderMaxId();

	public Order getOrderById(int id);

	public void updataOrder(Order order);

	public List<Order> getOrdersByid(Integer id);

	public void delOrderById(int id);


}
