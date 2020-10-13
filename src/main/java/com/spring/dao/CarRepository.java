package com.spring.dao;

import java.util.Set;

import com.spring.entity.CarEntity;
import com.spring.model.SearchCarModel;

public interface CarRepository {

	//Fetch Cars
	Set<CarEntity> fetch(SearchCarModel searchCarModel);
	
	//Get car by ID so that you can change its availability
	public CarEntity getCarById(int carId);
	//Change car availability
	public void changeCarAvailability(int carId);
	
}
