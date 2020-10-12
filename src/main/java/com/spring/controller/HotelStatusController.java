package com.spring.controller;

import com.spring.entity.CarEntity;
import com.spring.entity.MenuEntity;
import com.spring.entity.RoomEntity;
import com.spring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping("/hotelStatus")
public class HotelStatusController {
    @Autowired
    private AdminRoomService adminRoomService;
    @Autowired
    private AdminCarService adminCarService;
    @Autowired
    private AdminService<MenuEntity> adminMenuService;

    //@GetMapping("/hotelStatus")
    //public String hotelStatus() {
    //    return "hotelStatus";
    //}

    @GetMapping("/hotelStatus")
    public String showHotelStatus(Model model) {
        Map<String, Integer> roomInfo = getRoomInformation();
        model.addAttribute("roomInfo", roomInfo);
        model.addAttribute("foodInfo", getFoodInformation());
        model.addAttribute("carInfo", getCarInformation());
        return "hotelStatus";
    }

    private Map<String, Integer> getRoomInformation() {
        List<RoomEntity> roomList = adminRoomService.fetchAll();
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
        Map<String, Integer> roomInfo = new HashMap<>();
        roomInfo.put("totalNum", roomNums);
        roomInfo.put("occNum", occupiedNums);
        roomInfo.put("avaNum", availableNums);
        roomInfo.put("cleanNum", cleaningNums);
        roomInfo.put("maintainNum", maintainingNums);
        return roomInfo;
    }
    private Map<String, Integer> getFoodInformation() {
        List<MenuEntity> foodList = adminMenuService.fetchAll();
        int total = foodList.size();
        int cost = 0;
        for (MenuEntity food : foodList) {
            cost += food.getPrice();
        }
        cost /= total;
        Map<String, Integer> foodInfo = new HashMap<>();
        foodInfo.put("totalNum", total);
        foodInfo.put("avgCost", cost);
        return foodInfo;
    }
    private Map<String, Integer> getCarInformation() {
        List<CarEntity> carList = adminCarService.fetchAll();
        int avaNum = 0, unavaNum = 0, cost = 0;
        int carNum = 0;
        for (CarEntity car : carList) {
            carNum++;
            if (car.getCarStatus().equalsIgnoreCase("available")) {
                avaNum++;
            } else {
                unavaNum++;
            }
            cost += car.getCarPrice();
        }
        cost /= carNum;
        Map<String, Integer> carInfo = new HashMap<>();
        carInfo.put("totalNum", carNum);
        carInfo.put("avaNum", avaNum);
        carInfo.put("unavaNum", unavaNum);
        carInfo.put("avgCost", cost);
        return carInfo;
    }
}
