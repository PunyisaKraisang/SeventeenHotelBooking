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
@RequestMapping("/adminRoom")
public class AdminRoomController {
    @Autowired
    private AdminRoomService adminRoomService;

    @Autowired
    private AdminRoomReservationService adminRoomReservationService;

//    @GetMapping("/adminRoom")
//    public String adminRoom() {
//        return "adminRoom";
//    }

    @GetMapping("")
    public String roomList(Model model) {
        List<RoomEntity> allRooms = adminRoomService.getAllRooms();
        List<RoomEntity> availableRooms = adminRoomService.getAvailableRooms();
        List<RoomEntity> nonAvailableRooms = adminRoomService.getNonAvailableRooms();
        //System.out.println(rooms.size());
        List<RoomReservationEntity> reservations = adminRoomReservationService.getReservationList();
        model.addAttribute("allRooms", allRooms);
        model.addAttribute("roomList", availableRooms);
        model.addAttribute("nonAvailableList", nonAvailableRooms);
        model.addAttribute("reservationList", reservations);
        return "adminRoom";
    }

    @GetMapping("checkin")
    @ResponseBody
    public String roomCheckin() {
        return "admin";
    }

    @GetMapping("delete")
    @ResponseBody
    public String deleteRoom() {
        return "deleting...";
    }

    @GetMapping("editStatus")
    @ResponseBody
    public String editStatus() { return "link works"; }

    @GetMapping("reservation/checkin")
    @ResponseBody
    public String reservationCheckin() {
        return "Check in... change reservation status";
    }

    @GetMapping("reservation/checkout")
    @ResponseBody
    public String reservationCheckout() {
        return "Check out... chenge reservation status";
    }
}
