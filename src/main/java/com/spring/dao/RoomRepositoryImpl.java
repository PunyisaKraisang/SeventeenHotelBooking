package com.spring.dao;


import java.util.Date;
import java.util.List;

import com.spring.entity.RoomReservationEntity;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.RoomEntity;
import com.spring.model.RoomModel;
//import org.apache.log4j.Logger;
import org.hibernate.query.Query;


@Transactional
@Repository
public class RoomRepositoryImpl extends BaseRepository implements RoomRepository {

	private static final Logger LOGGER = Logger.getLogger(RoomRepositoryImpl.class);
	
	@Override
    public List<RoomEntity> getAllRooms() {
        Query query = getSession().createQuery("SELECT r FROM RoomEntity r ORDER BY r.roomId", RoomEntity.class);
        return (List<RoomEntity>) query.getResultList();
    }

	@Override
	public List<RoomEntity> getRoomsMeetRequirment(int numberOfPeople, String roomType) {
		Query query = getSession().createQuery("SELECT r FROM RoomEntity r WHERE r.maxCapacity>" + numberOfPeople, RoomEntity.class);
		return (List<RoomEntity>) query.getResultList();
	}

	@Override
	public void bookRoom(int roomId, String checkinDate, String checkoutDate) {
        // Query query = getSession().createQuery("")
		Session session = getSession();

		RoomReservationEntity roomReservationEntity = new RoomReservationEntity();
		// roomReservationEntity.setReservationId((int)Math.random() * (1000000 - 100000 + 100000) + 100000); // generate random reservation id
		roomReservationEntity.setCheckInTime(new Date(checkinDate));
		roomReservationEntity.setCheckOutTime(new Date(checkoutDate));
		roomReservationEntity.setReservationStatus("true");
		roomReservationEntity.setRoomId(roomId);
		roomReservationEntity.setServiceCharge(0); // O dollars for now
		roomReservationEntity.setTax(0); // 0 dollars for now
		roomReservationEntity.setTotalBill(0); // 0 dollars for now

		session.save(roomReservationEntity);

		//Commit the transaction
		// session.getTransaction().commit();
	}


}
