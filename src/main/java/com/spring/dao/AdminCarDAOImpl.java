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
    public List<CarEntity> listAllCars() {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<CarEntity> query = cb.createQuery(CarEntity.class);
        Root<CarEntity> cars = query.from(CarEntity.class);
        query.select(cars);
        query.orderBy(cb.asc(cars.get("carId")));
        return getSession().createQuery(query).getResultList();
    }

    @Override
    public void changeAvailability(int carId) {
        CarEntity updatingCar = getCarById(carId);
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
    public void deleteCar(int carId) {
        CarEntity deleteCar = getCarById(carId);
        getSession().delete(deleteCar);
    }

    @Override
    public void saveUpdateCar(CarEntity car) { getSession().saveOrUpdate(car); }

    private CarEntity getCarById(int carId) {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<CarEntity> cq = cb.createQuery(CarEntity.class);
        Root<CarEntity> cars = cq.from(CarEntity.class);
        Predicate condition = cb.equal(cars.get("carId"), carId);
        cq.where(condition);
        return getSession().createQuery(cq).getSingleResult();
    }
}
