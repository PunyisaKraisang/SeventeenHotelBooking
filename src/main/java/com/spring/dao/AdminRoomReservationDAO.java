package com.spring.dao;

import com.spring.entity.RoomReservationEntity;

import java.util.List;

public interface AdminRoomReservationDAO {
    public List<RoomReservationEntity> getReservationList();
}
