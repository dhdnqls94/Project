package com.project.web.product.dto;

public class DeliverOkDto {
	private int productNum; // 주문번호 PK
	private String name; // 유저 이름
	private String addr; // 유저 주소
	private String productName; // 제품이름
	private int productQty; // 제품 수량
	private int productTotal; // 제품 총 가격
	
	public int getProductNum() {
		return productNum;
	}
	
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddr() {
		return addr;
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public int getProductQty() {
		return productQty;
	}
	
	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}
	
	public int getProductTotal() {
		return productTotal;
	}
	
	public void setProductTotal(int productTotal) {
		this.productTotal = productTotal;
	}
	
	
}
