package com.project.web.product.dto;

// DeliverDB 배송관련 DTO
public class DDto {
	private String name; // 유저 이름
	private String phone; // 유저 핸드폰
	private String zipCode; // 유저 우편번호
	private String addr; // 유저 주소
	private String id; // 유저 아이디
	private String productName; // 제품이름
	private int productQty; // 제품 수량
	private int productTotal; // 제품 총 금액
	private int no; // 제품 넘버
	private int productnum; // 제품번호 PK
	
	public int getProductnum() {
		return productnum;
	}

	public void setProductnum(int productnum) {
		this.productnum = productnum;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getAddr() {
		return addr;
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	
}
