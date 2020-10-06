package com.spring.seventeen.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class LogInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger LOGGER = Logger.getLogger(LogInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String requestUrl = request.getRequestURL().toString();
		if (requestUrl.contains("resources")) {
			// Do not log resources load request
			return true;
		}
		
		LOGGER.info("-----------------------------------------------------------");
		LOGGER.info("Request url : " + request.getRequestURI());
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		String requestUrl = request.getRequestURL().toString();
		if (requestUrl.contains("resources")) {
			// Do not log resources load response
			return;
		}
		
		LOGGER.info("Response status: [" + response.getStatus() + "] " + request.getRequestURL());
	}
}
