package com.bookshop.model;

public class Books {
	private int id;
	private String name;
	private Double price;
	private String img_url;
	private int pnum;
	private String category;
	private String description;
	
	public Books(int id, String name, Double price, String img_url, int pnum, String category, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.img_url = img_url;
		this.pnum = pnum;
		this.category = category;
		this.description = description;
	}
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
