package com.spring.service;

import com.spring.entity.CarEntity;

import java.util.List;

public interface AdminCarService extends AdminService<CarEntity> {
    void changeCarStatus(int carId);
    //void updateExistingCar(CarEntity car);
}
