package com.spring.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.stream.Collectors;

import com.spring.dto.MenuOrderItemInfo;
import com.spring.dto.SearchMenu;
import com.spring.entity.AccountEntity;
import com.spring.entity.MenuEntity;
import com.spring.entity.MenuKeywordEntity;
import com.spring.entity.MenuOrderEntity;
import com.spring.entity.MenuOrderItemEntity;
import com.spring.model.AccountModel;
import com.spring.model.MenuKeywordModel;
import com.spring.model.MenuModel;
import com.spring.model.MenuOrderItemInfoModel;
import com.spring.model.SaveMenuOrderItemModel;
import com.spring.model.SaveMenuOrderModel;
import com.spring.model.SearchMenuModel;

public final class ModelUtil {
	
	private static final SimpleDateFormat MODEL_FORMAT = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	private ModelUtil() {
		
	}
	
	public static MenuModel parse(MenuEntity from) {
		MenuModel to = new MenuModel();
		to.setMenuId(from.getMenuId());
		to.setName(from.getName());
		to.setPrice(from.getPrice());
		to.setDescription(from.getDescription());
		to.setRecommended(from.isRecommended());
		to.setKeywords(from.getKeywords().stream().map((key) -> parse(key)).collect(Collectors.toSet()));
		return to;
	}

	public static MenuKeywordModel parse(MenuKeywordEntity from) {
		MenuKeywordModel to = new MenuKeywordModel();
		to.setKeywordId(from.getKeywordId());
		to.setValue(from.getValue());
		to.setCategory(from.getCategory());
		return to;
	}
	
	public static SearchMenu parse(SearchMenuModel from) {
		return new SearchMenu(from.getName(),
				(from.getEthnic() != null && !from.getEthnic().isEmpty()) ? Integer.parseInt(from.getEthnic()) : -1,
				(from.getDietary() != null && !from.getDietary().isEmpty()) ? Integer.parseInt(from.getDietary()) : -1,
				from.getMin(),
				from.getMax(),
				from.isRecommended());
	}
	
	public static MenuOrderEntity parse(String username, SaveMenuOrderModel from) {
		MenuOrderEntity to = new MenuOrderEntity();
		
		Timestamp expectedDate = getExpectedDeliveryDate(from.getDeliverDate(), from.getDeliverTime());

		to.setUsername(username);
		to.setTax(from.getTax());
		to.setServiceCharge(from.getServiceCharge());
		to.setTotalBill(from.getTotalBill());
		to.setOrderingDate(new Date(System.currentTimeMillis()));
		to.setItems(from.getItems().stream().map((item) -> parse(item, expectedDate)).collect(Collectors.toList()));
		return to;
	}
	
	public static MenuOrderItemEntity parse(SaveMenuOrderItemModel from, Timestamp expectedDate) {
		MenuOrderItemEntity to = new MenuOrderItemEntity();
		to.setMenuId(from.getMenuId());
		to.setQuantity(from.getQuantity());
		to.setExpectedDeliverDate(expectedDate);
		to.setStatus("pending");
		return to;
	}
	
	public static MenuOrderItemInfoModel parse(MenuOrderItemInfo from) {
		
		MenuOrderItemInfoModel to = new MenuOrderItemInfoModel();
		to.setOrderId(from.getOrderId());
		to.setMenuId(from.getMenuId());
		to.setMenuName(from.getMenuName());
		to.setCustomerName(from.getCustomerFirstName() + " " + from.getCustomerLastName());
		to.setQuantity(from.getQuantity());
		to.setStatus(from.getStatus());
		
		java.util.Date utilDate = new java.util.Date(from.getExpectedDeliverDate().getTime());
		String dateString = MODEL_FORMAT.format(utilDate);
		to.setExpectedDeliverDateTime(dateString);
		return to;
	}
	
	public static AccountModel parse(AccountEntity from) {	
		AccountModel to = new AccountModel();
		to.setUsername(from.getUsername());
		to.setCustomerId(from.getCustomerId());
		return to;
	}
	
	public static boolean isLogin(AccountModel accountModel) {
		
		if (accountModel == null) {
			return false;
		}
		
		if (accountModel.getUsername() == null) {
			return false;
		}
		
		return !accountModel.getUsername().isEmpty() 
				&& accountModel.getCustomerId() != 0;
	}
	
	private static Timestamp getExpectedDeliveryDate(String date, int time) {
		String timeStr = time < 10? ("0" + time) : "" + time;
		String expectedDateString = date + " " + timeStr + ":00:00";
		
		java.util.Date utilDate = null;
		try {
			utilDate = MODEL_FORMAT.parse(expectedDateString);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Timestamp expectedDate = utilDate != null ? new Timestamp(utilDate.getTime()) : null;
		return expectedDate;
	}
	
	public static CarModel parse(CarEntity from) {
		CarModel model = new CarModel();
		model.setCarId(from.getCarId());
		model.setCarName(from.getCarName());
		model.setCarType(from.getCarType());
		model.setCarPrice(from.getCarPrice());
		model.setMileage(from.getMileage());
		model.setAc(from.getAc());
		model.setManual(from.getManual());
		model.setTrunkSize(from.getTrunkSize());
		model.setCarStatus(from.getCarStatus());
		return model;
	}
	
	public static SearchCar parse(SearchCarModel from) {
		return new SearchCar(from.getCarName());
	}
	
}
