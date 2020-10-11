package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.entity.RoomEntity;
import com.spring.model.RoomModel;
import com.spring.service.RoomsService;
import com.spring.service.RoomReservationService;
@Controller
public class RoomsController {
	private static final Logger LOGGER = Logger.getLogger(RoomsController.class);
	
	
	@Autowired
	RoomsService service;
	
	@Autowired
    private RoomReservationService RoomReservationService;
	
	@GetMapping("/rooms")
	public String goToReservarionRoomPage(Model model) {
		 List<RoomEntity> rooms = service.getAllRooms();
	        //System.out.println(rooms.size());
	        // List<RoomReservationEntity> reservations = adminRoomReservationService.getReservationList();
	        model.addAttribute("roomList", rooms);
	        // model.addAttribute("reservationList", reservations);
	        return "rooms";
	}
    @PostMapping("/rooms")
    public String filterRooms(@RequestParam String checkinDate,
    		                  @RequestParam String checkoutDate,
    		                  @RequestParam String roomType,
    		                  @RequestParam int numberOfPeople,
	                          Model model) {
        System.out.println("u: " + roomType + ", p: " + numberOfPeople);
        //AdminEntity admin = adminLoginService.getAdmin(username, password);
    	List<RoomEntity> rooms = service.getRoomsMeetRequirment(numberOfPeople, roomType);
	        //System.out.println(rooms.size());
	        // List<RoomReservationEntity> reservations = adminRoomReservationService.getReservationList();
	    model.addAttribute("roomList", rooms);
	    model.addAttribute("checkinDate", checkinDate);
	    model.addAttribute("checkoutDate", checkoutDate);
		// model.addAttribute("reservationList", reservations);
	    return "rooms";
        //session.setAttribute("loggedAdmin", true);
        //return "redirect:/hotelStatus";
    }
    @PostMapping("/bookRoom")
	public String getRoomDetail(@RequestParam int roomIdSelected,
								@RequestParam String checkinDate,
								@RequestParam String checkoutDate,
	                            Model model) {
		System.out.println("roomId: " + roomIdSelected);
        service.bookRoom(roomIdSelected, checkinDate, checkoutDate);
        return "success";
	}
	
}
	

