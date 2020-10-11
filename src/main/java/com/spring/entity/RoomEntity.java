package com.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "room")
public class RoomEntity implements Serializable{
	
	private static final long serialVersionUID = -13154795123645236L;

	@Id
	@Column(name = "room_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomId;
	
	
	@Column(name = "room_floor")
	private int roomFloor;
	
	@Column(name = "room_price", nullable = false, precision = 2)
	private double roomPrice;
	
	@Column(name = "room_type", nullable = false)
	private String roomType;
	
	@Id
	@Column(name = "room_number")
	private int roomNumber;
	
	@Column(name = "room_status", nullable = false)
	private String roomStatus;
	
	
	@Column(name = "bed_number")
	private int bedNumber;
	
	@Column(name = "room_View", nullable = false)
	private String roomView;
	
	
	@Column(name = "max_capacity")
	private int maxCapacity;
	
	@Column(name = "bathtub")
	@Type(type = "true_false")
	private boolean bathtub;
	
	@Id
	@Column(name = "hotel_id")
    private int hotelId;
    
    
    public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	
	
	public int getRoomFloor() {
		return roomFloor;
	}
	public void setRoomFloor(int roomFloor) {
		this.roomFloor = roomFloor;
	}
	
	
	public double getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}
	
	
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	
	public String isRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	
	
	public int getBedNumber() {
		return bedNumber;
	}
	public void setBedNumber(int bedNumber) {
		this.bedNumber = bedNumber;
	}
	
	
	public String getRoomView() {
		return roomView;
	}
	public void setRoomView(String roomView) {
		this.roomView = roomView;
	}
	
	
	public int getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	
	
	public boolean isBathtub() {
		return bathtub;
	}
	public void setBathtub(boolean bathtub) {
		this.bathtub = bathtub;
	}
	
	
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	
}

