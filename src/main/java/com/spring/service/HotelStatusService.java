package com.spring.service;

import com.spring.entity.RoomEntity;
import com.spring.model.RoomModel;

import java.util.List;

public interface HotelStatusService{
    public List<RoomEntity> fetchAll();
}
