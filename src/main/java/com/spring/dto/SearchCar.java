package com.spring.dto;

public class SearchCar {

	private String carName;

	//Constructor (for ModelUtil)
	public SearchCar(String carName) {this.carName = carName;}
	
	//Getter (for CarRepository)
	public String getCarName() {return carName;}
	
}
