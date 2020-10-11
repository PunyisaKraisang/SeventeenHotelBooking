package com.spring.model;

import java.io.Serializable;
import java.util.List;

public class SaveMenuOrderModel implements Serializable {

	private static final long serialVersionUID = -87677725146936168L;
	
	private float tax;
	private float serviceCharge;
	private float totalBill;
	private String deliverDate;
	private int deliverTime;
	private List<SaveMenuOrderItemModel> items;
	
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
	
	public String getDeliverDate() {
		return deliverDate;
	}
	
	public void setDeliverDate(String deliverDate) {
		this.deliverDate = deliverDate;
	}
	
	public int getDeliverTime() {
		return deliverTime;
	}
	
	public void setDeliverTime(int deliverTime) {
		this.deliverTime = deliverTime;
	}
	
	public List<SaveMenuOrderItemModel> getItems() {
		return items;
	}
	
	public void setItems(List<SaveMenuOrderItemModel> items) {
		this.items = items;
	}
	
}
