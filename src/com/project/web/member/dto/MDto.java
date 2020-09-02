package com.project.web.member.dto;

public class MDto {

	private String member_Id;
	private String member_Pw;
	private String member_Name;
	private String member_Addr;
	private String member_Phone;
	private String member_Email;
	
	public MDto() {
		// TODO Auto-generated constructor stub
	}

	public MDto(String member_Id, String member_Pw, String member_Name, String member_Addr, String member_Phone,
			String member_Email) {
		super();
		this.member_Id = member_Id;
		this.member_Pw = member_Pw;
		this.member_Name = member_Name;
		this.member_Addr = member_Addr;
		this.member_Phone = member_Phone;
		this.member_Email = member_Email;
	}


	public String getMember_Id() {
		return member_Id;
	}

	public void setMember_Id(String member_Id) {
		this.member_Id = member_Id;
	}

	public String getMember_Pw() {
		return member_Pw;
	}

	public void setMember_Pw(String member_Pw) {
		this.member_Pw = member_Pw;
	}

	public String getMember_Name() {
		return member_Name;
	}

	public void setMember_Name(String member_Name) {
		this.member_Name = member_Name;
	}

	public String getMember_Addr() {
		return member_Addr;
	}

	public void setMember_Addr(String member_Addr) {
		this.member_Addr = member_Addr;
	}

	public String getMember_Phone() {
		return member_Phone;
	}

	public void setMember_Phone(String member_Phone) {
		this.member_Phone = member_Phone;
	}
	
	public String getMember_Email() {
		return member_Email;
	}

	public void setMember_Email(String member_Email) {
		this.member_Email = member_Email;
	}
}
