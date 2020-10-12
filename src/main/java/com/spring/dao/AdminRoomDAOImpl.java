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
    public List<RoomEntity> fetchAll() {
        return fetchAll(getSession(), RoomEntity.class, "roomId");
    }

    @Override
    public void saveNewEntity(RoomEntity room) {
        saveNewEntity(getSession(), room);
    }

    @Override
    public List<RoomEntity> getNonAvailableRooms() {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<RoomEntity> query = cb.createQuery(RoomEntity.class);
        Root<RoomEntity> room = query.from(RoomEntity.class);
        Predicate condition = cb.notEqual(room.get("roomStatus"), "Available");
        query.where(condition);
        return getSession().createQuery(query).getResultList();
    }

    @Override
    public List<RoomEntity> getAvailableRooms() {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<RoomEntity> query = cb.createQuery(RoomEntity.class);
        Root<RoomEntity> room = query.from(RoomEntity.class);
        Predicate condition = cb.equal(room.get("roomStatus"), "Available");
        query.where(condition);
        return getSession().createQuery(query).getResultList();
    }

    @Override
    public void roomStatusEditing(int roomId, String statusChangeTo) {
        String updateHQL = "UPDATE RoomEntity r SET r.roomStatus = :status WHERE r.roomId = :id";
        Query query = getSession().createQuery(updateHQL);
        query.setParameter("status", statusChangeTo);
        query.setParameter("id", roomId);
        query.executeUpdate();
    }

    @Override
    public void deleteEntity(int roomId) {
        deleteEntity(getSession(), roomId);
    }

    @Override
    public RoomEntity getById(int roomId) {
        return getById(getSession(), RoomEntity.class, roomId, "roomId");
    }

    @Override
    public void updateExistEntity(RoomEntity room) {
        RoomEntity existingRoom = getById(room.getRoomId());
        existingRoom.setBathtub(room.getBathtub());
        existingRoom.setBedNumber(room.getBedNumber());
        existingRoom.setMaxCapacity(room.getMaxCapacity());
        existingRoom.setRoomPrice(room.getRoomPrice());
        existingRoom.setRoomType(room.getRoomType());
        getSession().update(existingRoom);
    }
}
