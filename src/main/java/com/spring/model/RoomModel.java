package com.spring.model;

import java.io.Serializable;

public class RoomModel implements Serializable {
    private static final long serialVersionUID = -8456431578951324L;
    private int roomId;
    private int roomFloor;
    private double roomPrice;
    private String roomType;
    private int roomNumber;
    private boolean roomStatus;
    private int bedNumber;
    private String roomView;
    private int maxCapacity;
    private boolean bathtub;
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


    public boolean isRoomStatus() {
        return roomStatus;
    }
    public void setRoomStatus(boolean roomStatus) {
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
