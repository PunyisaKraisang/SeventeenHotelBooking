package com.spring.service;

import com.spring.entity.CarEntity;

import java.util.List;

public interface AdminCarService {
    public List<CarEntity> listAllCars();
    public void changeCarStatus(int carId);
    public void deleteCar(int carId);
    public void saveUpdateCar(CarEntity car);
}
