package com.spring.service;

import com.spring.entity.RoomEntity;
import com.spring.model.RoomModel;

import java.util.List;

public interface AdminRoomService extends AdminService<RoomEntity> {
    List<RoomEntity> getNonAvailableRooms();
    List<RoomEntity> getAvailableRooms();
    void roomStatusEditing(int roomId, String statusChangeTo);
    //void updatingExistRoom(RoomEntity room);
}
