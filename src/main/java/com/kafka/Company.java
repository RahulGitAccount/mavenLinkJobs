package com.kafka;
public class Company {
	
	String name;
	String ceo;
	String area;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Company(String name, String ceo, String area) {
		super();
		this.name = name;
		this.ceo = ceo;
		this.area = area;
	}
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
