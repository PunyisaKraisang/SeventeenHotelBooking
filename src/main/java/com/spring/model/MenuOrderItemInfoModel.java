package com.spring.model;

public class MenuOrderItemInfoModel {
	
	private int orderId;
	private int menuId;
	private String menuName;
	private String customerName;
	private int quantity;
	private String expectedDeliverDateTime;
	private String status;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getExpectedDeliverDateTime() {
		return expectedDeliverDateTime;
	}

	public void setExpectedDeliverDateTime(String expectedDeliverDateTime) {
		this.expectedDeliverDateTime = expectedDeliverDateTime;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
