package com.spring.service;

import com.spring.dao.AdminCarDAO;
import com.spring.entity.CarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminCarServiceImpl implements AdminCarService {
    @Autowired
    private AdminCarDAO adminCarDAO;

    @Override @Transactional
    public List<CarEntity> listAllCars() {
        return adminCarDAO.listAllCars();
    }

    @Override @Transactional
    public void changeCarStatus(int carId) { adminCarDAO.changeAvailability(carId); }

    @Override @Transactional
    public void deleteCar(int carId) { adminCarDAO.deleteCar(carId); }

    @Override @Transactional
    public void saveUpdateCar(CarEntity car) { adminCarDAO.saveUpdateCar(car); }

    @Override @Transactional
    public CarEntity getCarById(int carId) { return adminCarDAO.getCarById(carId); }

    @Override @Transactional
    public void updateExistingCar(CarEntity car) { adminCarDAO.updateExistingCar(car); }
}
