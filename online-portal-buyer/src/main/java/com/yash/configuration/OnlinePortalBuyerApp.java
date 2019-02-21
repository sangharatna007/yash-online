
package com.yash.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.yash.*")
@PropertySource("classpath:application.properties")
public class OnlinePortalBuyerApp {

	@Autowired
	private Environment env;

	/*
	 * @Bean public LocalSessionFactoryBean sessionFactory() {
	 * LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	 * sessionFactory.setDataSource(dataSource());
	 * sessionFactory.setPackagesToScan(new String[] { "com.yash.model" });
	 * sessionFactory.setHibernateProperties(hibernateProperties()); return
	 * sessionFactory; }
	 * 
	 * private Properties hibernateProperties() { Properties properties = new
	 * Properties(); properties.put("hibernate.dialect",
	 * env.getRequiredProperty("hibernate.dialect"));
	 * properties.put("hibernate.show_sql",
	 * env.getRequiredProperty("hibernate.show_sql"));
	 * properties.put("hibernate.format_sql",
	 * env.getRequiredProperty("hibernate.format_sql")); return properties; }
	 * 
	 * @Autowired
	 * 
	 * @Bean public HibernateTransactionManager transactionManager(SessionFactory s)
	 * { HibernateTransactionManager txManager = new HibernateTransactionManager();
	 * txManager.setSessionFactory(s); return txManager; }
	 */

	@Bean
	public DataSource dataSource() {
		System.out.println("*************" + env.getProperty("jdbc.url"));
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(env.getProperty("jdbc.url"));
		driverManagerDataSource.setUsername(env.getProperty("jdbc.user"));
		driverManagerDataSource.setPassword(env.getProperty("jdbc.password"));
		driverManagerDataSource.setDriverClassName(env.getProperty("jdbc.driver"));
		return driverManagerDataSource;
	}
	@Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        return jdbcTemplate;
    }
	
}