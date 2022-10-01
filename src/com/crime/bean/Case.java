package com.crime.bean;


import java.time.LocalDate;


public class Case {
	
	@Override
	public String toString() {
		return "Case [name=" + name + ", address=" + address + ", date=" + date + ", crime=" + crime + ", desc=" + desc
				+ ", mainSuspect=" + mainSuspect + ", criminalname=" + criminalname + ", criminalage=" + criminalage
				+ ", criminalgender=" + criminalgender + ", criminaladdress=" + criminaladdress + ", arrestedArea="
				+ arrestedArea + "]";
	}

	private String name;
	private String address;
	private LocalDate date;
	private String crime;
	private String desc;
	private String mainSuspect;
	
	
	private String criminalname;
	private int criminalage ;
	private String criminalgender;
	private String criminaladdress;
	private String arrestedArea;
	
	public Case() {
		// TODO Auto-generated constructor stub
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCrime() {
		return crime;
	}

	public void setCrime(String crime) {
		this.crime = crime;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getMainSuspect() {
		return mainSuspect;
	}

	public void setMainSuspect(String mainSuspect) {
		this.mainSuspect = mainSuspect;
	}

	public String getCriminalname() {
		return criminalname;
	}

	public void setCriminalname(String criminalname) {
		this.criminalname = criminalname;
	}

	public int getCriminalage() {
		return criminalage;
	}

	public void setCriminalage(int criminalage) {
		this.criminalage = criminalage;
	}

	public String getCriminalgender() {
		return criminalgender;
	}

	public void setCriminalgender(String criminalgender) {
		this.criminalgender = criminalgender;
	}

	public String getCriminaladdress() {
		return criminaladdress;
	}

	public void setCriminaladdress(String criminaladdress) {
		this.criminaladdress = criminaladdress;
	}

	public String getArrestedArea() {
		return arrestedArea;
	}

	public void setArrestedArea(String arrestedArea) {
		this.arrestedArea = arrestedArea;
	}
	
	
	


}
