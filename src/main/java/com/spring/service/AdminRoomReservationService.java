package com.spring.service;

import com.spring.entity.RoomReservationEntity;

import java.util.List;

public interface AdminRoomReservationService {
    List<RoomReservationEntity> fetchAll();
    void deleteEntity(int rid);
    RoomReservationEntity getById(int rid);
    void changeStatus(int rid, String statusChangeTo);
}