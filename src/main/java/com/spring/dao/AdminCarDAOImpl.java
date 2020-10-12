package com.spring.dao;

import com.spring.entity.CarEntity;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Transactional
@Repository
public class AdminCarDAOImpl extends BaseRepository implements AdminCarDAO {
    @Override
    public List<CarEntity> fetchAll() {
        return fetchAll(getSession(), CarEntity.class, "carId");
    }

    @Override
    public void changeAvailability(int carId) {
        CarEntity updatingCar = getById(carId);
        String updateHQL = "UPDATE CarEntity c SET c.carStatus = :status WHERE c.carId = :id";
        Query query = getSession().createQuery(updateHQL);
        if (updatingCar.getCarStatus().equalsIgnoreCase("available")) {
            query.setParameter("status", "Unavailable");
        } else {
            query.setParameter("status", "Available");
        }
        query.setParameter("id", carId);
        query.executeUpdate();
    }

    @Override
    public void deleteEntity(int carId) {
        deleteEntity(getSession(), carId);
    }

    @Override
    public void saveNewEntity(CarEntity car) { saveNewEntity(getSession(), car); }

    @Override
    public CarEntity getById(int carId) {
        return getById(getSession(), CarEntity.class, carId, "carId");
    }

    @Override
    public void updateExistEntity(CarEntity car) {
        CarEntity existingCar = getById(car.getCarId());
        existingCar.setAc(car.getAc());
        existingCar.setCarName(car.getCarName());
        existingCar.setCarPrice(car.getCarPrice());
        existingCar.setCarStatus(car.getCarStatus());
        existingCar.setCarType(car.getCarType());
        existingCar.setManual(car.getManual());
        existingCar.setMileage(car.getMileage());
        existingCar.setTrunkSize(car.getTrunkSize());
        getSession().update(existingCar);
    }
}
