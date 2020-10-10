package com.spring.dao;

import com.spring.entity.RoomEntity;
import com.spring.model.RoomModel;

import java.util.List;

public interface AdminRoomDAO {
    public List<RoomEntity> getAllRooms();
    public void saveUpdateRoom(RoomEntity room);
    public List<RoomEntity> getNonAvailableRooms();
    public List<RoomEntity> getAvailableRooms();
}
