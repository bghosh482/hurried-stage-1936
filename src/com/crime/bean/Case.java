package com.crime.bean;

import java.util.Date;

public class Case {
	
	private String name;
	
	private String address;
	private Date date;
	private String desc;
	

	public Case() {
		// TODO Auto-generated constructor stub
	}

	
	public Case(String name, String address, Date date, String desc) {
		super();
		this.name = name;
		this.address = address;
		this.date = date;
		this.desc = desc;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}



}
