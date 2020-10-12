package com.spring.service;

import com.spring.dao.AdminRoomReservationDAO;
import com.spring.entity.RoomReservationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Service
public class AdminRoomReservationServiceImpl implements AdminRoomReservationService {
    @Autowired //@Qualifier("adminRoomReservationDAO")
    AdminRoomReservationDAO adminRoomReservationDAO;

    @Override
    @Transactional
    public List<RoomReservationEntity> fetchAll() {
        return adminRoomReservationDAO.fetchAll();
    }

    @Override @Transactional
    public RoomReservationEntity getById(int rid) { return adminRoomReservationDAO.getById(rid); }

    @Override @Transactional
    public void deleteEntity(int rid) { adminRoomReservationDAO.deleteEntity(rid); }

    @OneToMany @Transactional
    public void changeStatus(int rid, String statusChangeTo) { adminRoomReservationDAO.changeStatus(rid, statusChangeTo); }

}
