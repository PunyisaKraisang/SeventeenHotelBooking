package com.spring.dao;

import java.util.Set;

import com.spring.dto.SearchCar;
import com.spring.entity.CarEntity;

public interface CarRepository {

	//Fetch Cars
	Set<CarEntity> fetch(SearchCar searchCar);
	
	//Get car by ID so that you can change its availability
	public CarEntity getCarById(int carId);
	//Change car availability
	public void changeCarAvailability(int carId);
	
}
