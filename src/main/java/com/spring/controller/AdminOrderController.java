package com.spring.controller;

import com.spring.dto.DeliverMenuOrderItem;
import com.spring.model.MenuOrderItemInfoModel;
import com.spring.service.AdminOrderService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/adminOrder")
public class AdminOrderController {

	private static final Logger LOGGER = Logger.getLogger(AdminOrderController.class);
	
	@Autowired
	private AdminOrderService orderService;
	
    @GetMapping("")
    public String listOrder(Model model) {
    	
    	LOGGER.info("Fetch order list with pending status");
    	List<MenuOrderItemInfoModel> orderList = orderService.fetchPendingOrder();
    	
    	LOGGER.info("Pass order list through model");
		model.addAttribute("orderList", orderList);
        return "adminOrder";
    }

    @GetMapping("deliver")
    public String deliverOrder(int orderId, int menuId) {
    	LOGGER.info("Deliver order=" + orderId + ", menu=" + menuId);
    	
    	DeliverMenuOrderItem orderItem = new DeliverMenuOrderItem(orderId, menuId);
    	orderService.deliverOrder(orderItem);
    	
    	LOGGER.info("Redirect to order page");
        return "redirect:/adminOrder";
    }
}
