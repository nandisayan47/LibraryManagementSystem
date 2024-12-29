package com.sayan.lms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Book_LMS")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bid;
	private String bname;
	private String bauthor;
	private String bcategory;
	private String blink;
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
	public String getBlink() {
		return blink;
	}
	public void setBlink(String blink) {
		this.blink = blink;
	}
	

}
