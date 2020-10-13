package com.spring.service;

import java.util.List;
import com.spring.model.CarModel;

public interface CarService {
	
	//Retrieve cars
	List<CarModel> fetchCar(CarModel carModel);
	
	//Change car table 'status' column 
	public void changeCarStatus(int carId);
	
}
