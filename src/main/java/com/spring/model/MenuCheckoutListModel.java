package com.spring.model;

import java.io.Serializable;
import java.util.List;

public class MenuCheckoutListModel implements Serializable {

	private static final long serialVersionUID = 6341085607653416005L;
	
	private double totalPrice;
	private List<MenuCheckoutModel> items;

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public List<MenuCheckoutModel> getItems() {
		return items;
	}

	public void setItems(List<MenuCheckoutModel> items) {
		this.items = items;
	}

}
