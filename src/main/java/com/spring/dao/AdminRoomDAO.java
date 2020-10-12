package com.spring.dao;

import com.spring.entity.RoomEntity;
import com.spring.model.RoomModel;
import com.spring.service.AdminService;

import java.util.List;

public interface AdminRoomDAO extends AdminDAO<RoomEntity> {
    List<RoomEntity> getNonAvailableRooms();
    List<RoomEntity> getAvailableRooms();
    void roomStatusEditing(int roomId, String statusChangeTo);
    //void updatingExistRoom(RoomEntity room);
}
