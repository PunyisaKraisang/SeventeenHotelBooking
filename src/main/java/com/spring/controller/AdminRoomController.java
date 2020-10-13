package com.spring.controller;

import com.spring.entity.RoomEntity;
import com.spring.entity.RoomReservationEntity;
import com.spring.service.AdminRoomReservationService;
import com.spring.service.AdminRoomService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/adminRoom")
public class AdminRoomController {
    @Autowired
    private AdminRoomService adminRoomService;

    @Autowired
    private AdminRoomReservationService adminRoomReservationService;

    private static final Logger LOGGER = Logger.getLogger(AdminRoomController.class);

    @GetMapping("")
    public String roomList(Model model) {
        List<RoomEntity> allRooms = adminRoomService.fetchAll();
        List<RoomEntity> availableRooms = adminRoomService.getAvailableRooms();
        List<RoomEntity> nonAvailableRooms = adminRoomService.getNonAvailableRooms();
        List<RoomReservationEntity> reservations = adminRoomReservationService.fetchAll();
        LOGGER.info("Pass for entities through model");
        model.addAttribute("allRooms", allRooms);
        model.addAttribute("roomList", availableRooms);
        model.addAttribute("nonAvailableList", nonAvailableRooms);
        model.addAttribute("reservationList", reservations);
        return "adminRoom";
    }

    @GetMapping("checkin")
    public String roomCheckin(int roomId, Model model) {
        try {
            LOGGER.info("Editing status of room with id: " + roomId);
            adminRoomService.roomStatusEditing(roomId, "Occupied");
            return "redirect:/adminRoom";
        } catch (Exception e) {
            LOGGER.info("Editing room status failed");
            model.addAttribute("checkInFailed", "Checkin Failed");
            return "redirect:/adminRoom";
        }
    }

    @GetMapping("delete")
    public String deleteRoom(int roomId, Model model) {
        try {
            LOGGER.info("Deleting room with id: " + roomId);
            adminRoomService.deleteEntity(roomId);
            return "redirect:/adminRoom";
        } catch (Exception e) {
            LOGGER.info("Fail to delete room");
            model.addAttribute("deleteFailed", "Delete room failed");
            return "redirect:/adminRoom";
        }
    }

    @GetMapping("edit")
    public String editRoomForm(Model model, int roomId) {
        LOGGER.info("Get room by id: " + roomId);
        RoomEntity updatingRoom = adminRoomService.getById(roomId);
        LOGGER.info("Pass entity through model");
        model.addAttribute("updatingRoom", updatingRoom);
        return "adminRoomEditing";
    }

    @PostMapping("edit")
    public String editRoom(@ModelAttribute("updatingRoom") RoomEntity room, int roomId) {
        LOGGER.info("updating room information with id: " + roomId);
        adminRoomService.updateExistEntity(room);
        return "redirect:/adminRoom";
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
    public String reservationCheckin(int reservationId, Model model) {
        try {
            LOGGER.info("Checking in reservation");
            adminRoomReservationService.changeStatus(reservationId, "In Room");
            return "redirect:/adminRoom";
        } catch (Exception e) {
            LOGGER.info("CheckIn Failed");
            model.addAttribute("checkinFailed", "Checkin Failed");
            return "redirect:/adminRoom";
        }
    }

    @GetMapping("reservation/checkout")
    public String reservationCheckout(int reservationId, Model model) {
        try {
            LOGGER.info("Checking out reservation");
            adminRoomReservationService.changeStatus(reservationId, "Complete");
            return "redirect:/adminRoom";
        } catch (Exception e) {
            LOGGER.info("CheckOut failed");
            model.addAttribute("checkoutFailed", "checkout Failed");
            return "redirect:/adminRoom";
        }
    }

    private String roomStatusEditing(int roomId, String option, Model model) {
        try {
            LOGGER.info("Editing room status");
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
            LOGGER.info("Editing room status failed");
            model.addAttribute("roomStatusEditingFailed", "Fail to edit room status");
            return "redirect:/adminRoom";
        }
    }
}
