package com.spring.service;

import java.util.List;

import com.spring.model.CarModel;
import com.spring.model.SearchCarModel;

public interface CarService {
	
	//Retrieve cars
	List<CarModel> fetchCar(SearchCarModel searchCarModel);
	
	//Change car table 'status' column 
	public void changeCarStatus(int carId);
	
}
