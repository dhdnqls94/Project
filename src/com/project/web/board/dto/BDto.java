package com.project.web.board.dto;

import java.sql.Timestamp;

public class BDto {

	private int bNum;
	private String bWriter;
	private String bEmail;
	private String bTitle;
	private String bPassword;
	private Timestamp bDate;
	private int ref;
	private int reStep;
	private int reLevel;
	private int readCount;
	private String content;

	public BDto(int bNum, String bWriter, String bEmail, String bTitle, String bPassword, Timestamp bDate, int ref,
			int reStep, int reLevel, int readCount, String content) {
		super();
		this.bNum = bNum;
		this.bWriter = bWriter;
		this.bEmail = bEmail;
		this.bTitle = bTitle;
		this.bPassword = bPassword;
		this.bDate = bDate;
		this.ref = ref;
		this.reStep = reStep;
		this.reLevel = reLevel;
		this.readCount = readCount;
		this.content = content;
	}

	public BDto(int bNum, String bWriter, String bEmail, String bTitle, Timestamp bDate, int readCount) {
		super();
		this.bNum = bNum;
		this.bWriter = bWriter;
		this.bEmail = bEmail;
		this.bTitle = bTitle;
		this.bDate = bDate;
		this.readCount = readCount;
	}



	public BDto(int bNum, String bTitle, String bWriter, Timestamp bDate, int readCount) {
		super();
		this.bNum = bNum;
		this.bTitle = bTitle;
		this.bWriter = bWriter;
		this.bDate = bDate;
		this.readCount = readCount;
	}



	public BDto(String bEmail, String bPassword) {
		super();
		this.bEmail = bEmail;
		this.bPassword = bPassword;
	}

	public BDto() {
	}

	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	public String getbWriter() {
		return bWriter;
	}
	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}
	public String getbEmail() {
		return bEmail;
	}
	public void setbEmail(String bEmail) {
		this.bEmail = bEmail;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbPassword() {
		return bPassword;
	}
	public void setbPassword(String bPassword) {
		this.bPassword = bPassword;
	}
	public Timestamp getbDate() {
		return bDate;
	}
	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getReStep() {
		return reStep;
	}
	public void setReStep(int reStep) {
		this.reStep = reStep;
	}
	public int getReLevel() {
		return reLevel;
	}
	public void setReLevel(int reLevel) {
		this.reLevel = reLevel;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
