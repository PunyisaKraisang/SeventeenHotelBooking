package com.spring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.RoomRepository;
import com.spring.entity.RoomEntity;
import com.spring.util.ModelUtil;


@Service
public class RoomsServiceImpl implements RoomsService{

	private static final Logger LOGGER = Logger.getLogger(RoomsServiceImpl.class);

	@Autowired
	RoomRepository roomRepository;

	@Override @Transactional
    public List<RoomEntity> getAllRooms() {
        return roomRepository.getAllRooms();
    }

	@Override
	public List<RoomEntity> getRoomsMeetRequirment(int numberOfPeople, String roomType) {
		// TODO Auto-generated method stub
		return roomRepository.getRoomsMeetRequirment(numberOfPeople, roomType);
	}

	@Override
	public void bookRoom(int roomId, String checkinDate, String checkoutDate) {
		roomRepository.bookRoom(roomId, checkinDate, checkoutDate);
	}

	//@Transactional
	//public List<RoomModel> fetchRoom() {
		
		//LOGGER.info("Fetch all room");
		//List<RoomEntity> entityList = roomRepository.fetch();
		//List<RoomModel> modelList = entityList.stream().map(ModelUtil::parse).collect(Collectors.toList());

		//LOGGER.info("Fetch all room success");
		//return modelList;
	//}
}
