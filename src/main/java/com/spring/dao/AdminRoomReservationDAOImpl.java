package com.spring.dao;

import com.spring.entity.RoomEntity;
import com.spring.entity.RoomReservationEntity;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Transactional
@Repository
public class AdminRoomReservationDAOImpl extends BaseRepository implements AdminRoomReservationDAO {
    @Override
    public List<RoomReservationEntity> getReservationList() {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<RoomReservationEntity> query = cb.createQuery(RoomReservationEntity.class);
        Root<RoomReservationEntity> reservations = query.from(RoomReservationEntity.class);
        query.select(reservations);
        query.orderBy(cb.asc(reservations.get("reservationId")));
        return getSession().createQuery(query).getResultList();
    }
}
