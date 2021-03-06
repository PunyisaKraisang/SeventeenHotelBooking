package com.spring.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.spring", "com.spring.entity"})
@PropertySource(value = "classpath:application.properties")
public class HibernateConfig {

	private static final Logger LOGGER = Logger.getLogger(HibernateConfig.class);
	
	@Autowired
	private Environment environment;
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LOGGER.info("Instantiate session factory");
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.spring.entity" });
		return sessionFactory;
	}
	
	@Bean
	public DataSource dataSource() {
		LOGGER.info("Instantiate datasource");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("jdbc.driver"));
		dataSource.setUrl(environment.getProperty("jdbc.url"));
		dataSource.setUsername(environment.getProperty("jdbc.username"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		return dataSource;
	}
	
	@Bean
	public Properties hibernateProperties() {
		LOGGER.info("Load hibernate properties");
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory ses) {
		LOGGER.info("Instantiate transaction manager");
		HibernateTransactionManager manager = new HibernateTransactionManager();
		manager.setSessionFactory(ses);
		return manager;
	}
	
}
