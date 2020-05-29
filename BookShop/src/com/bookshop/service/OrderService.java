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
	
	public void submitOrder(Order order){
		orderDao.addOrder(order);
	}
}
