package com.spring.model;

import java.io.Serializable;
import java.util.List;

public class SaveMenuOrderModel implements Serializable {

	private static final long serialVersionUID = -87677725146936168L;
	
	private double tax;
	private double serviceCharge;
	private double totalBill;
	private int reservationId;
	private String deliverDate;
	private int deliverTime;
	private List<SaveMenuOrderItemModel> items;
	
	public double getTax() {
		return tax;
	}
	
	public void setTax(double tax) {
		this.tax = tax;
	}
	
	public double getServiceCharge() {
		return serviceCharge;
	}
	
	public void setServiceCharge(double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	
	public double getTotalBill() {
		return totalBill;
	}
	
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	
	public int getReservationId() {
		return reservationId;
	}
	
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
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

	@Override
	public String toString() {
		return "SaveMenuOrderModel [tax=" + tax + ", serviceCharge=" + serviceCharge + ", totalBill=" + totalBill
				+ ", reservationId=" + reservationId + ", "
				+ (deliverDate != null ? "deliverDate=" + deliverDate + ", " : "") + "deliverTime=" + deliverTime + ", "
				+ (items != null ? "items=" + items : "") + "]";
	}
	
}
