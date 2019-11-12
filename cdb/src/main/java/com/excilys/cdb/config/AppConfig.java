package com.excilys.cdb.config;

import java.util.Properties;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement 
@ComponentScans(value = { @ComponentScan("com.excilys.cdb.dao"), @ComponentScan("com.excilys.cdb.service"),@ComponentScan("com.excilys.cdb.mapper") })

public class AppConfig {

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan("com.excilys.cdb.entities");
		factoryBean.setHibernateProperties(hibernateProperties());
		return factoryBean;
	}
	
	private  Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		ResourceBundle res = ResourceBundle.getBundle("db");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", res.getString("hibernate.hbm2ddl.auto"));
		hibernateProperties.setProperty("hibernate.dialect", res.getString("hiberbate.dialect"));
		return hibernateProperties;
	}

	@Bean
	public DataSource dataSource() {
		ResourceBundle res = ResourceBundle.getBundle("db");
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(res.getString("mysql.driver"));
		dataSource.setUrl(res.getString("mysql.url"));
		dataSource.setUsername(res.getString("mysql.user"));
		dataSource.setPassword(res.getString("mysql.password"));
		
		return dataSource;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}
}
