package com.spring.model;

import java.io.Serializable;

public class CarModel implements Serializable {

	private static final long serialVersionUID = 2557846423936418438L;
	
	private int carId;
	private String name;
	private String type;
	private float price;
	private float mileage;
	private String ac;
	private String manual;
	private float trunkSize;
	private String carStatus;

	//Getters
	public int     getCarId() {return carId;}
	public String  getCarName() {return name;}
	public String  getCarType() {return type;}
	public float  getCarPrice() {return price;}
	public float  getMileage() {return mileage;}
	public String getAc() {return ac;}
	public String getManual() {return manual;}
	public float  getTrunkSize() {return trunkSize;}
	public String  getCarStatus() {return carStatus;}
	
	//Setters
	public void setCarId(int carId) {this.carId = carId;}
	public void setCarName(String name) {this.name = name;}
	public void setCarType(String type) {this.type = type;}
	public void setCarPrice(float price) {this.price = price;}
	public void setMileage(float mileage) {this.mileage = mileage;}
	public void setAc(String ac) {this.ac = ac;}
	public void setManual(String manual) {this.manual = manual;}
	public void setTrunkSize(float trunkSize) {this.trunkSize = trunkSize;}
	public void setCarStatus(String carStatus) {this.carStatus = carStatus;}
	
}
