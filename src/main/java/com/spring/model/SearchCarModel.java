package com.spring.model;

import java.io.Serializable;

public class SearchCarModel implements Serializable {

	private static final long serialVersionUID = -5959073992189173669L;
	
	private String carName;
	
	//Constructor (for ModelUtil)
	public SearchCarModel(String carName) {this.carName = carName;}
	
	//Getter
	public String getCarName() {return carName;}
	
	//Setter
	public void setCarName(String carName) {this.carName = carName;}

}
