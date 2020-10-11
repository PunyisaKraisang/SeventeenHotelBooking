package com.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class MenuOrderItemId implements Serializable {

	private static final long serialVersionUID = 4744596016134859022L;
	
	private Integer orderId;
	private Integer menuId;
	
	public MenuOrderItemId() {
	} 	
	
	public MenuOrderItemId(Integer orderId, Integer menuId) {
		this.orderId = orderId;
		this.menuId = menuId;
	}
	
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	} 	

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		MenuOrderItemId other = (MenuOrderItemId) obj;
		return orderId == other.getOrderId() && menuId == other.getMenuId();
	}

}
