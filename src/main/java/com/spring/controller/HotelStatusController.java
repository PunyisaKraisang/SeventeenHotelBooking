package com.spring.controller;

import com.spring.entity.RoomEntity;
import com.spring.service.HotelStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hotelStatus")
public class HotelStatusController {
    @Autowired
    private HotelStatusService hotelStatusService;

    @GetMapping("/")
    public String showHotelStatus(Model model) {
        List<RoomEntity> roomList = hotelStatusService.getAllRooms();
        int roomNums = 0;
        int occupiedNums = 0;
        int availableNums = 0;
        int cleaningNums = 0;
        int maintainingNums = 0;
        for (RoomEntity room : roomList) {
            roomNums++;
            if (room.getRoomStatus().equalsIgnoreCase("occupied")) {
                occupiedNums++;
            } else if (room.getRoomStatus().equalsIgnoreCase("available")) {
                availableNums++;
            } else if (room.getRoomStatus().equalsIgnoreCase("cleaning")) {
                cleaningNums++;
            } else {
                maintainingNums++;
            }
        }
        model.addAttribute("roomNums", roomNums);
        model.addAttribute("occupiedNums", occupiedNums);
        model.addAttribute("availableNums", availableNums);
        model.addAttribute("cleaningNums", cleaningNums);
        model.addAttribute("maintainingNums", maintainingNums);
        return "hotelStatus";
    }
}
