package com.spring.service;

import com.spring.dao.AdminRoomReservationDAO;
import com.spring.entity.RoomReservationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminRoomReservationServiceImpl implements AdminRoomReservationService {
    @Autowired //@Qualifier("adminRoomReservationDAO")
    AdminRoomReservationDAO adminRoomReservationDAO;

    @Override
    @Transactional
    public List<RoomReservationEntity> getReservationList() {
        return adminRoomReservationDAO.getReservationList();
    }
}
