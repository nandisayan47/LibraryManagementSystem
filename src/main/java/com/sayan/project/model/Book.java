package com.sayan.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bid;
	private String bname;
	private String bauthor;
	private String bcategory;
	private String blink;
	
	
	private int flag;
	
	
//	private boolean available;
//	public boolean isAvailable() {
//		return available;
//	}
//	public void setAvailable(boolean available) {
//		this.available = available;
//	}
	
	
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getBlink() {
		return blink;
	}
	public void setBlink(String blink) {
		this.blink = blink;
	}
	public Long getBid() {
		return bid;
	}
	public void setBid(Long bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public String getBcategory() {
		return bcategory;
	}
	public void setBcategory(String bcategory) {
		this.bcategory = bcategory;
	}
	
}
