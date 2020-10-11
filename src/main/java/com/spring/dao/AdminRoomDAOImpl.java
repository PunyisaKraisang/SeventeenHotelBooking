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
//        Query query = getSession().createQuery("SELECT r FROM RoomEntity r ORDER BY r.roomId", RoomEntity.class);
//        return (List<RoomEntity>) query.getResultList();
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<RoomEntity> query = cb.createQuery(RoomEntity.class);
        Root<RoomEntity> room = query.from(RoomEntity.class);
        query.select(room);
        query.orderBy(cb.asc(room.get("roomId")));
        return getSession().createQuery(query).getResultList();
    }

    @Override
    public void saveUpdateRoom(RoomEntity room) {
        getSession().saveOrUpdate(room);
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
    public void deleteRoom(int roomId) {
        RoomEntity delete = getRoomById(roomId);
        getSession().delete(delete);
    }

    @Override
    public RoomEntity getRoomById(int roomId) {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<RoomEntity> query = cb.createQuery(RoomEntity.class);
        Root<RoomEntity> room = query.from(RoomEntity.class);
        Predicate condition = cb.equal(room.get("roomId"), roomId);
        query.where(condition);
        return getSession().createQuery(query).getSingleResult();
    }

    @Override
    public void updatingExistRoom(RoomEntity room) {
        RoomEntity existingRoom = getRoomById(room.getRoomId());
        existingRoom.setBathtub(room.getBathtub());
        existingRoom.setBedNumber(room.getBedNumber());
        existingRoom.setMaxCapacity(room.getMaxCapacity());
        existingRoom.setRoomPrice(room.getRoomPrice());
        existingRoom.setRoomType(room.getRoomType());
        getSession().update(existingRoom);
    }
}
