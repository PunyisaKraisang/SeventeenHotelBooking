package com.spring.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.CarRepository;
import com.spring.entity.CarEntity;
import com.spring.model.CarModel;
import com.spring.util.ModelUtil;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository carRepository;
	
	//Retrieve cars
	@Override
	@Transactional
	public List<CarModel> fetchCar(CarModel carModel) {
		
		Set<CarEntity> entityList = carRepository.fetch(ModelUtil.parse(carModel));
		List<CarModel> modelList  = entityList.stream().map(ModelUtil::parse).collect(Collectors.toList());

		return modelList;
	}
	
	//Change car table 'status' column 
	@Override 
	@Transactional
    public void changeCarStatus(int carId) { carRepository.changeCarAvailability(carId); }
	
}
