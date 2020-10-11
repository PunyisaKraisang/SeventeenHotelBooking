package com.spring.dao;

import java.util.List;

import com.spring.entity.RoomEntity;
import com.spring.model.RoomModel;

public interface RoomRepository {
	//List<RoomEntity> fetch();
	List<RoomEntity> getAllRooms();
	
	List<RoomEntity> getRoomsMeetRequirment(int numberOfPeople, String roomType);

	void bookRoom(int roomId, String checkinDate, String checkoutDate);

}
