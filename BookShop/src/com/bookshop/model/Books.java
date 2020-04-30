package com.bookshop.model;

public class Books {
	private int bid;
	private String bookname;
	private Double b_price;
	private String image;
	private int stock;
	public Books(int bid, String bookname, Double b_price, String image, int stock) {
		super();
		this.bid = bid;
		this.bookname = bookname;
		this.b_price = b_price;
		this.image = image;
		this.stock = stock;
	}
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public Double getB_price() {
		return b_price;
	}
	public void setB_price(Double b_price) {
		this.b_price = b_price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}
