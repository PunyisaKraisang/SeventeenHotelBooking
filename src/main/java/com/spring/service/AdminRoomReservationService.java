package com.spring.service;

import com.spring.entity.RoomReservationEntity;

import java.util.List;

public interface AdminRoomReservationService {
    public List<RoomReservationEntity> getReservationList();
}