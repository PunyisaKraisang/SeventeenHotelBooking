package com.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "room_reservation")

public class RoomReservationEntity implements Serializable{
	
	private static final long serialVersionUID = -8696179071054771098L;

	@Id
	@Column(name = "reservation_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "reservationIdSeq")
	@SequenceGenerator(
			name = "reservationIdSeq",
			sequenceName = "reservation_id",
			initialValue = 1000,
			allocationSize = 1
	)
	private int reservationId;
	
	@Column(name = "room_id")
	private int roomId;
	
	@Column(name = "checkin_time")
	private Date checkInTime;
	
	@Column(name = "checkout_time")
	private Date checkOutTime;

	@Column(name = "reservation_status", nullable = false)
	private String reservationStatus;
    
	@Column(name = "tax", nullable = false, precision = 2)
	private double tax;
	
	@Column(name = "service_charge", nullable = false, precision = 2)
	private double serviceCharge;
	
	@Column(name = "total_bill", nullable = false, precision = 2)
	private double totalBill;

	
	public RoomReservationEntity() {
		super();
	}

	public RoomReservationEntity(int reservationId, int roomId, Date checkInTime, Date checkOutTime,
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
