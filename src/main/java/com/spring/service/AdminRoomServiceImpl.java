package com.spring.service;

import com.spring.dao.AdminRoomDAO;
import com.spring.entity.RoomEntity;
import com.spring.model.RoomModel;
import com.spring.util.ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class AdminRoomServiceImpl implements AdminRoomService {
    @Autowired
    private AdminRoomDAO adminRoomDAO;

    @Override @Transactional
    public List<RoomEntity> fetchAll() {
        return adminRoomDAO.fetchAll();
    }

    @Override @Transactional
    public List<RoomEntity> getNonAvailableRooms() {
        return adminRoomDAO.getNonAvailableRooms();
    }

    @Override @Transactional
    public List<RoomEntity> getAvailableRooms() {
        return adminRoomDAO.getAvailableRooms();
    }

    @Override @Transactional
    public void saveNewEntity(RoomEntity room) {
        adminRoomDAO.saveNewEntity(room);
    }

    @Override @Transactional
    public void roomStatusEditing(int roomId, String statusChangeTo) { adminRoomDAO.roomStatusEditing(roomId, statusChangeTo); }

    @Override @Transactional
    public void deleteEntity(int roomId) { adminRoomDAO.deleteEntity(roomId); }

    @Override @Transactional
    public RoomEntity getById(int roomId) { return adminRoomDAO.getById(roomId); }

    @Override @Transactional
    public void updateExistEntity(RoomEntity room) { adminRoomDAO.updateExistEntity(room); }
}
