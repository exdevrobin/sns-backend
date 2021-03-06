package org.hov.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="org.hov")
@EnableTransactionManagement
public class AppConfig {
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sns");
		dataSource.setUsername("exdev");
		dataSource.setPassword("exdev");
		return dataSource;
	}
	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
	   	properties.put("hibernate.show_sql", "true");
	   	properties.put("hibernate.hbm2ddl.auto", "update");
	   	properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
	   	return properties;
	}
	    
   @Bean (name = "sessionFactory")
   @Autowired
   public LocalSessionFactoryBean getSessionFactory() {
	   LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	   sessionFactory.setDataSource(getDataSource());
	   sessionFactory.setPackagesToScan("org.hov.model");
	   sessionFactory.setHibernateProperties(getHibernateProperties());
	   return sessionFactory;
   }
	    
   @Bean(name = "transactionManager")
   @Autowired
   public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
   }
   
   @Bean
   public JavaMailSender getJavaMailSender() {
       JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
       mailSender.setHost("smtpout.secureserver.net");
       mailSender.setPort(465);
       mailSender.setUsername("enter_email_here");
       mailSender.setPassword("enter_your_password_here");
        
       Properties props = mailSender.getJavaMailProperties();
       props.put("mail.transport.protocol", "smtp");
       props.put("mail.smtp.auth", "true");
       props.put("mail.debug", "true");
       
       /* Google Mail Specific settings*/
      //props.put("mail.smtp.starttls.enable", "true");
       
       /* Go Daddy Mail specific settings */
       props.put("mail.smtp.ssl.enable", "true");
       props.put("mail.smtp.ssl.trust", "*");
        
       return mailSender;
   }
}
