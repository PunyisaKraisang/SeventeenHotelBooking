package com.spring.model;

import java.io.Serializable;
import java.util.Date;



public class RoomReservationModel implements Serializable{
	

	private static final long serialVersionUID = -6309720112011079922L;
	
	private int reservationId;
	private int roomId;
	private Date checkInTime;
	private Date checkOutTime;
	private String reservationStatus;
	private double tax;
	private double serviceCharge;
	private double totalBill;
	
	
	
	public RoomReservationModel() {
		super();
	}

	
	
	public RoomReservationModel(int reservationId, int roomId, Date checkInTime, Date checkOutTime,
			String reservationStatus, double tax, double serviceCharge, double totalBill) {
		super();
		this.reservationId = reservationId;
		this.roomId = roomId;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.reservationStatus = reservationStatus;
		this.tax = tax;
		this.serviceCharge = serviceCharge;
		this.totalBill = totalBill;
	}



	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public Date getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}

	public Date getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(Date checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public String getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

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
    

}
