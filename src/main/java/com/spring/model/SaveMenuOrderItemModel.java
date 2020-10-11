package com.spring.model;

import java.io.Serializable;

public class SaveMenuOrderItemModel implements Serializable {

	private static final long serialVersionUID = -4446444082014751904L;
	
	private int menuId;
	private int quantity;
	
	public int getMenuId() {
		return menuId;
	}
	
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "SaveMenuOrderItemModel [menuId=" + menuId + ", quantity=" + quantity + "]";
	}
	
}
