package com.spring.dao;

import com.spring.entity.RoomReservationEntity;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Transactional
@Repository
public class AdminRoomReservationDAOImpl extends BaseRepository implements AdminRoomReservationDAO {
    @Override
    public List<RoomReservationEntity> getReservationList() {
        Query query = getSession().createQuery("SELECT r FROM RoomReservationEntity r WHERE r.reservationStatus =: status");
        query.setParameter("status", "Pending");
        return (List<RoomReservationEntity>) query.getResultList();
    }
}
