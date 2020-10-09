package com.spring.controller;

import com.spring.entity.RoomEntity;
import com.spring.entity.RoomReservationEntity;
import com.spring.service.AdminRoomReservationService;
import com.spring.service.AdminRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdminRoomController {
    @Autowired
    private AdminRoomService adminRoomService;

    @Autowired
    private AdminRoomReservationService adminRoomReservationService;

//    @GetMapping("/adminRoom")
//    public String adminRoom() {
//        return "adminRoom";
//    }

    @GetMapping("/adminRoom")
    public String roomList(Model model) {
        List<RoomEntity> rooms = adminRoomService.getAvailableRooms();
        //System.out.println(rooms.size());
        List<RoomReservationEntity> reservations = adminRoomReservationService.getReservationList();
        model.addAttribute("roomList", rooms);
        model.addAttribute("reservationList", reservations);
        return "adminRoom";
    }

    @GetMapping("/adminRoom/checkin")
    @ResponseBody
    public String checkinTest() {
        return "link works";
    }
}
