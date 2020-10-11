package com.spring.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.RoomReservationRepository;
import com.spring.entity.RoomReservationEntity;


@Service
public class RoomReservationServiceImpl implements RoomReservationService {
	@Autowired
    RoomReservationRepository roomReservationRepository;

    @Override
    @Transactional
	
	public void addReservation(RoomReservationEntity reservation){
		roomReservationRepository.addReservation(reservation);

	}

	public List<RoomReservationEntity> getReservationsByReservationId(int reservationrId){
		return roomReservationRepository.getReservationsByReservationId(reservationrId);
	}

}
