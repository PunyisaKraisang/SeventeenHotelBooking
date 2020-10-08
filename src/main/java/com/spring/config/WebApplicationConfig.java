package com.spring.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.spring.service.LogInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
		"com.spring.controller",
		"com.spring.service",
		"com.spring.admin"})
@PropertySource(value = "classpath:s3.properties")
public class WebApplicationConfig implements WebMvcConfigurer{
	
	private static final Logger LOGGER = Logger.getLogger(WebApplicationConfig.class);

	@Bean
	public InternalResourceViewResolver viewResolver() {
		LOGGER.info("Load internal resource view resolver");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LOGGER.info("Register log interception");
	    registry.addInterceptor(new LogInterceptor());
	}
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		LOGGER.info("Register webapp resource handler");
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);
    }
}
