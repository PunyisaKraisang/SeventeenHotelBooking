package com.spring.dao;

import com.spring.entity.RoomEntity;
import com.spring.model.RoomModel;
import org.apache.log4j.Logger;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Transactional
@Repository
public class AdminRoomDAOImpl extends BaseRepository implements AdminRoomDAO {
    private static final Logger LOGGER = Logger.getLogger(MenuRepositoryImpl.class);
    @Override
    public List<RoomEntity> getAllRooms() {
        Query query = getSession().createQuery("SELECT r FROM RoomEntity r ORDER BY r.roomId", RoomEntity.class);
        return (List<RoomEntity>) query.getResultList();
    }

    @Override
    public void saveUpdateRoom(RoomEntity room) {
        getSession().saveOrUpdate(room);
    }

    @Override
    public List<RoomEntity> getOccupiedRooms() {
        Query query = getSession().createQuery("SELECT r FROM RoomEntity r WHERE r.roomStatus = :status");
        query.setParameter("status", "Occupied");
        return (List<RoomEntity>) query.getResultList();
    }

    @Override
    public List<RoomEntity> getAvailableRooms() {
//        Query query = getSession().createQuery("SELECT r FROM RoomEntity r WHERE r.roomStatus = :status");
//        query.setParameter("status", "Available");
//        List<RoomEntity> rooms = (List<RoomEntity>) query.getResultList();
//        LOGGER.info("get available rooms with size " + rooms.size());
//        return rooms;
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<RoomEntity> query = cb.createQuery(RoomEntity.class);
        Root<RoomEntity> room = query.from(RoomEntity.class);
        Predicate condition = cb.equal(room.get("roomStatus"), "Available");
        query.where(condition);
        return getSession().createQuery(query).getResultList();
    }
}
