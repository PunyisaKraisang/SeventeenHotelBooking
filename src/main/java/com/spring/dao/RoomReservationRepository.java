package com.spring.dao;

import java.util.List;


import com.spring.entity.RoomReservationEntity;

public interface RoomReservationRepository {
	
	void addReservation(RoomReservationEntity reservation);

	List<RoomReservationEntity> getReservationsByReservationId(int reservationId);

}
