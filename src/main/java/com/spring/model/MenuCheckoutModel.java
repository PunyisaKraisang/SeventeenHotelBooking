package com.spring.model;

import java.io.Serializable;

public class MenuCheckoutModel implements Serializable {

	private static final long serialVersionUID = -2564931082218089259L;
	private int id;
	private String name;
	private double price;
	private int qtt;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQtt() {
		return qtt;
	}
	
	public void setQtt(int qtt) {
		this.qtt = qtt;
	}
	
	@Override
	public String toString() {
		return "MenuCheckoutModel [id=" + id + ", " + (name != null ? "name=" + name + ", " : "") + "price=" + price
				+ ", qtt=" + qtt + "]";
	}
}
