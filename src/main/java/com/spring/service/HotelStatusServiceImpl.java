package com.spring.service;

import com.spring.dao.AdminRoomDAO;
import com.spring.entity.RoomEntity;
import com.spring.model.RoomModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HotelStatusServiceImpl implements HotelStatusService {
    @Autowired
    private AdminRoomDAO adminRoomDAO;

    @Override @Transactional
    public List<RoomEntity> getAllRooms() {
        return adminRoomDAO.getAllRooms();
    }
}
