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
import org.springframework.web.bind.annotation.PostMapping;
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
    public String roomCheckin(int roomId, Model model) {
        try {
            adminRoomService.roomStatusEditing(roomId, "Occupied");
            return "redirect:/adminRoom";
        } catch (Exception e) {
            model.addAttribute("checkInFailed", "Checkin Failed");
            return "redirect:/adminRoom";
        }
    }

    @GetMapping("delete")
    public String deleteRoom(int roomId, Model model) {
        try {
            adminRoomService.deleteRoom(roomId);
            return "redirect:/adminRoom";
        } catch (Exception e) {
            model.addAttribute("deleteFailed", "Delete room failed");
            return "redirect:/adminRoom";
        }
    }

    @GetMapping("maintenance")
    public String roomMaintaining(int roomId, Model model) {
        return roomStatusEditing(roomId, "Maintaining", model);
    }

    @GetMapping("cleaning")
    public String roomCleaning(int roomId, Model model) {
        return roomStatusEditing(roomId, "Cleaning", model);
    }

    @GetMapping("ready")
    public String roomReadyToUse(int roomId, Model model) {
        return roomStatusEditing(roomId, "Available", model);
    }

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

    private String roomStatusEditing(int roomId, String option, Model model) {
        try {
            if (option.equalsIgnoreCase("maintaining")) {
                adminRoomService.roomStatusEditing(roomId, "Maintaining");
                return "redirect:/adminRoom";
            } else if (option.equalsIgnoreCase("cleaning")) {
                adminRoomService.roomStatusEditing(roomId, "Cleaning");
                return "redirect:/adminRoom";
            } else {
                adminRoomService.roomStatusEditing(roomId, "Available");
                return "redirect:/adminRoom";
            }
        } catch (Exception e) {
            model.addAttribute("roomStatusEditingFailed", "Fail to edit room status");
            return "redirect:/adminRoom";
        }
    }
}
