package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.spring.entity.RoomEntity;
import com.spring.model.AccountModel;
import com.spring.model.MenuCheckoutListModel;
import com.spring.model.RoomModel;
import com.spring.model.SaveMenuOrderModel;
import com.spring.service.RoomsService;
import com.spring.util.ModelUtil;
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
	        model.addAttribute("roomList", rooms);
	        return "rooms";
	}
    @PostMapping("/rooms")
    public String filterRooms(@RequestParam String checkinDate,
    		                  @RequestParam String checkoutDate,
    		                  @RequestParam String roomType,
    		                  @RequestParam int numberOfPeople,
	                          Model model) {
        System.out.println("u: " + roomType + ", p: " + numberOfPeople);
    	List<RoomEntity> rooms = service.getRoomsMeetRequirment(numberOfPeople, roomType);
	    model.addAttribute("roomList", rooms);
	    model.addAttribute("checkinDate", checkinDate);
	    model.addAttribute("checkoutDate", checkoutDate);
	    return "rooms";
 
    }
    @PostMapping("/roomDetail")
	public String getRoomDetail(@RequestParam int roomIdSelected,
								@RequestParam String checkinDate,
								@RequestParam String checkoutDate,
	                            Model model) {
		System.out.println("roomId: " + roomIdSelected);
        service.bookRoom(roomIdSelected, checkinDate, checkoutDate);
        return "success";
	}
    
    @PostMapping("/bookRoom")
	public String bookRoom(
			@SessionAttribute(name = "accountModel", required = false) AccountModel accountModel,
			Model model) {
		
		if (!ModelUtil.isLogin(accountModel)) {
			LOGGER.info("No login user, redirect to login page");
			return "redirect:/login";
		}
		LOGGER.info("Pass data to checkput page");
	
		
		return "bookRoom";
	}
	
}
	

