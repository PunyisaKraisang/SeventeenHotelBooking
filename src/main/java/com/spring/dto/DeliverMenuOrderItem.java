package com.spring.dto;

public class DeliverMenuOrderItem {

	private int orderId;
	private int menuId;
	
	public DeliverMenuOrderItem(int orderId, int menuId) {
		this.orderId = orderId;
		this.menuId = menuId;
	}

	public int getOrderId() {
		return orderId;
	}

	public int getMenuId() {
		return menuId;
	}
	
	
}
