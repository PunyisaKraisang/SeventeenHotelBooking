package com.spring.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "Menu_Order_Item")
@IdClass(MenuOrderItemId.class)
public class MenuOrderItemEntity implements Serializable {

	private static final long serialVersionUID = -6202682740583970507L;

	@Id
	@Column(name = "Order_id")
	private int orderId;
	
	@Id
	@Column(name = "Menu_id")
	private int menuId; 
	
	@Column(name = "Quantity")
	private int quantity; 
	
	@Column(name = "Expected_deviler_datetime")
	private Timestamp expectedDeliverDate;
	
	@Column(name = "Devilered_datetime")
	private Timestamp deliveredDate;
	
	@Column(name = "Status")
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Timestamp getExpectedDeliverDate() {
		return expectedDeliverDate;
	}

	public void setExpectedDeliverDate(Timestamp expectedDeliverDate) {
		this.expectedDeliverDate = expectedDeliverDate;
	}

	public Timestamp getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(Timestamp deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
