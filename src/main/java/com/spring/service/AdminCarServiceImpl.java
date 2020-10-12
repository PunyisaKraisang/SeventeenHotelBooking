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
    public List<CarEntity> fetchAll() {
        return adminCarDAO.fetchAll();
    }

    @Override @Transactional
    public void changeCarStatus(int carId) { adminCarDAO.changeAvailability(carId); }

    @Override @Transactional
    public void deleteEntity(int carId) { adminCarDAO.deleteEntity(carId); }

    @Override @Transactional
    public void saveNewEntity(CarEntity car) { adminCarDAO.saveNewEntity(car); }

    @Override @Transactional
    public CarEntity getById(int carId) { return adminCarDAO.getById(carId); }

    @Override @Transactional
    public void updateExistEntity(CarEntity car) { adminCarDAO.updateExistEntity(car); }
}
