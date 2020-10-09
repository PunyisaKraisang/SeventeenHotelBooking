package com.spring.dao;

import com.spring.entity.RoomEntity;
import com.spring.model.RoomModel;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Transactional
@Repository
public class AdminRoomDAOImpl extends BaseRepository implements AdminRoomDAO {
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
        Query query = getSession().createQuery("SELECT r FROM RoomEntity r WHERE r.roomStatus = :status");
        query.setParameter("status", "Available");
        return (List<RoomEntity>) query.getResultList();
    }
}
