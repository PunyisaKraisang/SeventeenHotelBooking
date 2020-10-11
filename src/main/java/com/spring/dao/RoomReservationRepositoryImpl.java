package com.spring.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.RoomReservationEntity;

@Transactional
@Repository
public class RoomReservationRepositoryImpl extends BaseRepository implements RoomReservationRepository{
	@Override
	public List<RoomReservationEntity> getReservationsByReservationId(int reservationId) {
        Query query = getSession().createQuery("SELECT r FROM RoomReservationEntity r WHERE r.reservationStatus =: status");
        query.setParameter("status", "Pending");
        return (List<RoomReservationEntity>) query.getResultList();
    }

	@Override
	public void addReservation(RoomReservationEntity reservation) {
		// TODO Auto-generated method stub
		
	}

}
