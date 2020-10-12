package com.spring.dao;

import com.spring.entity.RoomReservationEntity;

import java.util.List;

public interface AdminRoomReservationDAO {
    List<RoomReservationEntity> fetchAll();
    RoomReservationEntity getById(int rid);
    void deleteEntity(int rid);
    void changeStatus(int rid, String statusChangeTo);
}
