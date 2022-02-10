package com.springmvc.config;

import java.util.Properties;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:database.properties")
public class HibernateConfig {
	@Autowired
	private Environment ev;
    @Bean
	public LocalSessionFactoryBean getSessionFactoryBean() {
		LocalSessionFactoryBean fac = new LocalSessionFactoryBean();
		fac.setPackagesToScan("com.springmvc.pojo");
		fac.setDataSource(getDataSource());
		fac.setHibernateProperties(getHibernateProperties());
		return fac;
	}
    @Bean
	public DataSource getDataSource() {
		DriverManagerDataSource d = new DriverManagerDataSource();
		d.setDriverClassName(ev.getProperty("hibernate.connection.driverClass"));
        d.setUrl(ev.getProperty("hibernate.connection.url"));
        d.setUsername(ev.getProperty("hibernate.connection.username"));
        d.setPassword(ev.getProperty("hibernate.connection.password"));
		return d;
	}
    
     private Properties getHibernateProperties() {
    	 Properties props= new Properties();
    	 props.setProperty(org.hibernate.cfg.Environment.SHOW_SQL, ev.getProperty("hibernate.showSql"));
        return props;
     }
     
     @Bean
     public HibernateTransactionManager transactionManager() {
    	 HibernateTransactionManager h=new HibernateTransactionManager();
    	 h.setSessionFactory(getSessionFactoryBean().getObject());
    	 return h;
     }

}
