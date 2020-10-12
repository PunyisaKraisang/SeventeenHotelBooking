package com.spring.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Menu_Order")
public class MenuOrderEntity implements Serializable {

	private static final long serialVersionUID = 1840733362432276885L;

	@Id
	@Column(name = "Order_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;

	@Column(name = "Username", nullable = true)
	private String username; 
	
	@Column(name = "Ordering_time")
	private Date orderingDate;
	
	@Column(name = "Tax")
	private float tax;

	@Column(name = "Service_charge")
	private float serviceCharge;
	
	@Column(name = "Total_bill")
	private float totalBill;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Order_id", referencedColumnName = "Order_Id")
	private List<MenuOrderItemEntity> items;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public Date getOrderingDate() {
		return orderingDate;
	}

	public void setOrderingDate(Date orderingDate) {
		this.orderingDate = orderingDate;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public float getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(float serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public float getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(float totalBill) {
		this.totalBill = totalBill;
	}

	public List<MenuOrderItemEntity> getItems() {
		return items;
	}

	public void setItems(List<MenuOrderItemEntity> items) {
		this.items = items;
	}
	
}
