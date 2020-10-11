package com.spring.service;

import java.util.List;


import com.spring.entity.RoomReservationEntity;



public interface RoomReservationService {

	public void addReservation(RoomReservationEntity reservation);
	public List<RoomReservationEntity> getReservationsByReservationId(int reservationrId);
	
	

}
