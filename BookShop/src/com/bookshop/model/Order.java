/**
 * 
 */
package com.bookshop.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 张家宝
 * @data 2020年5月4日 下午5:39:55
 * @describe 
 */
public class Order {
	private Integer id;
	private Integer user_id;
	private Double money;
	private String receiverName;
	private String receiverPhone;
	private String receiverAddress;
	private Integer payState;
	private Date ordertime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public Integer getPayState() {
		return payState;
	}
	public void setPayState(Integer payState) {
		this.payState = payState;
	}
	public Date getOrdertime() {
		Date nowdate=new Date();
		//转换时间格式
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		ordertime = Timestamp.valueOf(simpleDate.format(nowdate));

		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", user_id=" + user_id + ", money=" + money + ", receiverName=" + receiverName
				+ ", receiverPhone=" + receiverPhone + ", receiverAddress=" + receiverAddress + ", payState=" + payState
				+ ", ordertime=" + ordertime + "]";
	}
	
	
	
}
