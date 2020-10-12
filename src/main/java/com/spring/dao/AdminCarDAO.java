package com.spring.dao;

import com.spring.entity.CarEntity;
import com.spring.service.AdminService;

import java.util.List;

public interface AdminCarDAO extends AdminDAO<CarEntity> {
    void changeAvailability(int carId);
    //void updateExistingCar(CarEntity car);
}
