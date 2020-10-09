package com.spring.service;

import com.spring.entity.RoomEntity;
import com.spring.model.RoomModel;

import java.util.List;

public interface AdminRoomService {
    public List<RoomEntity> getAllRooms();
    public List<RoomEntity> getOccupiedRooms();
    public List<RoomEntity> getAvailableRooms();
    public void saveUpdateRoom(RoomEntity room);
}
