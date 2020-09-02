package com.project.web.product.dto;

public class PDto {
	private int no;
	private String name;
	private int category;
	private int price;
	private String img;
	private String info;
	private int qty;
	private int total;
	
	
	public PDto(int no, String name, int price, String img, int qty) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.img = img;
		this.qty = qty;
	}
	
	public PDto() { }

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCategory() {
		return category;
	}
	
	public void setCategory(int category) {
		this.category = category;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getImg() {
		return img;
	}
	
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	
}
