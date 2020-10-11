package com.spring.config;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	private static final Logger LOGGER = Logger.getLogger(WebInitializer.class);

	@Override
	protected Class<?>[] getRootConfigClasses() {
		LOGGER.info("Mapping hibernate configuration class on root");
		return new Class[] { HibernateConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		LOGGER.info("Mapping servlet configuration class");
		return new Class[] { WebApplicationConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		LOGGER.info("Mapping servlet url");
		return new String[] { "/" };
	}

}
