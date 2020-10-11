package com.spring.service;

import java.util.List;

import com.spring.entity.RoomEntity;

public interface RoomsService {
	public List<RoomEntity> getAllRooms();
	public List<RoomEntity> getRoomsMeetRequirment(int numberOfPeople, String roomType);
	public void bookRoom(int roomId, String checkinDate, String checkoutDate);
	//public int add( RoomModel roomModel);
	//public int edit(RoomModel roomModel);
	//public int delete(Long id);
	//public List<RoomModel> findList(Map<String, Object> queryMap);
	//public List<RoomModel> findAll();


}
