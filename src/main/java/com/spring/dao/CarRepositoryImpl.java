package com.spring.dao;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.CarEntity;
import com.spring.model.SearchCarModel;

@Transactional
@Repository
public class CarRepositoryImpl extends BaseRepository implements CarRepository {
	
	//Fetch cars
	public Set<CarEntity> fetch(SearchCarModel searchCarModel) {

		Set<Integer> carIdSet = fetchCarId(searchCarModel);
		Set<CarEntity> result = fetchCar(carIdSet);
	
		return result;
	}
	
	//Retrieve car IDs
	private Set<Integer> fetchCarId(SearchCarModel searchCarModel) {
		
		//CriteriaBuilder class is used to construct criteria queries
		//getSession() returns the current session
		//getCriteriaBuilder() returns an instance of CriteriaBuilder for the creation of CriteriaQuery objects
		//The 3 lines below are equivalent to: SELECT root FROM CarEntity root
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		
		//The CriteriaQuery class is used to represent the built query
		CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
		Root<CarEntity> root = query.from(CarEntity.class);
		
		// Add search criteria
		List<Predicate> predicate = buildCriteria(builder, searchCarModel, root);
		query.where(builder.and(predicate.toArray(new Predicate[predicate.size()])) );
		
		// Project only car ID
		query.select(root.get("carId"));
		
		//The Query interface can use getResultList() to run SELECT queries where more than one result object is expected
		//We fetch these results as car IDs
		Set<Integer> result = new LinkedHashSet<Integer>(getSession().createQuery(query).getResultList());

		return result;
	}
	
	//Retrieve cars from car IDs
	private Set<CarEntity> fetchCar(Set<Integer> carIdSet) {
		
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<CarEntity> query = builder.createQuery(CarEntity.class);
		Root<CarEntity> root = query.from(CarEntity.class);

		// Add in criteria by car ID 
		In<Integer> inClause =  builder.in(root.get("carId"));
		carIdSet.forEach(id -> inClause.value(id));
		query.where(inClause);
		
		// Fetch result
		Set<CarEntity> result = new LinkedHashSet<CarEntity>(
				getSession().createQuery(query).getResultList());
		
		return result;
	}
	
	//Name search criteria
	private List<Predicate> buildCriteria(CriteriaBuilder builder, SearchCarModel searchCarModel, Root<CarEntity> root) {
		
		List<Predicate> predicate = new ArrayList<>();
		
		
		if (searchCarModel.getCarName() != null && !searchCarModel.getCarName().isEmpty()) {
			predicate.add(builder.like(builder.lower(root.get("carName")), "%" + searchCarModel.getCarName().toLowerCase() + "%"));
		}
		
		return predicate;
	}
	
	//Get car by ID so that you can change its availability
	@Override
    public CarEntity getCarById(int carId) {
		
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<CarEntity> query = builder.createQuery(CarEntity.class);
        Root<CarEntity> cars = query.from(CarEntity.class);
        
        query.where(builder.equal(cars.get("carId"), carId));
        
        return getSession().createQuery(query).getSingleResult();
    }
	
	//Change car availability
	@Override
    public void changeCarAvailability(int carId) {
		
        CarEntity updatingCar = getCarById(carId);
        String updateHQL = "UPDATE CarEntity c SET c.carStatus = :status WHERE c.carId = :id";
        
        Query<?> query = getSession().createQuery(updateHQL);
        
        if (updatingCar.getCarStatus().equalsIgnoreCase("available")) {
            query.setParameter("status", "Unavailable");
        } else {
            query.setParameter("status", "Available");
        }
        
        query.setParameter("id", carId);
        query.executeUpdate();
    }
	
}
