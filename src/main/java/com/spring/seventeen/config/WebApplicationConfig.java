package com.spring.seventeen.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.spring.seventeen.service.LogInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
		"com.spring.seventeen.controller",
		"com.spring.seventeen.service" })
public class WebApplicationConfig implements WebMvcConfigurer{
	
	private static final Logger LOGGER = Logger.getLogger(WebApplicationConfig.class);

	@Bean
	public InternalResourceViewResolver viewResolver() {
		
		LOGGER.info("Load internal resource view resolver");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		
		return viewResolver;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(new LogInterceptor());
	}
}
