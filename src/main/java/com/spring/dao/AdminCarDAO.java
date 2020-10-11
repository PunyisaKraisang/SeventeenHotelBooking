package com.spring.dao;

import com.spring.entity.CarEntity;

import java.util.List;

public interface AdminCarDAO {
    public List<CarEntity> listAllCars();
    public void changeAvailability(int carId);
    public void deleteCar(int carId);
    public void saveUpdateCar(CarEntity car);
    public CarEntity getCarById(int carId);
    public void updateExistingCar(CarEntity car);
}
