package com.spring.service;

import java.util.List;

import com.spring.entity.RoomEntity;

public interface RoomsService {
	public List<RoomEntity> getAllRooms();
	public List<RoomEntity> getRoomsMeetRequirment(int numberOfPeople, String roomType);
	public void bookRoom(int roomId, String checkinDate, String checkoutDate);


}
