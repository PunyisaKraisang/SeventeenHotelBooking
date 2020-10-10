package com.spring.service;

import com.spring.entity.RoomEntity;
import com.spring.model.RoomModel;

import java.util.List;

public interface AdminRoomService {
    public List<RoomEntity> getAllRooms();
    public List<RoomEntity> getNonAvailableRooms();
    public List<RoomEntity> getAvailableRooms();
    public void saveUpdateRoom(RoomEntity room);
    public void roomStatusEditing(int roomId, String statusChangeTo);
    public void deleteRoom(int roomId);
}
