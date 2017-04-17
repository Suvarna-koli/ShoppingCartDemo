package com.niit.Mobitel.Config;

import java.util.Locale.Category;
import java.util.Properties;
import com.niit.Mobitel.DAO.*;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.Mobitel.DAO.ProductDAO;

@Configuration
@ComponentScan("com.niit.Mobitel")
@EnableTransactionManagement
public class ApplicationConfig {

	@Bean(name="dataSource")
	public DataSource getH2DataSource() 
	{
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	System.out.println("Starting of the method getH2DataSource");
	
	dataSource.setDriverClassName("org.h2.Driver");
	dataSource.setUrl("jdbc:h2:~/test/shopping");
	dataSource.setUsername("sa");
	dataSource.setPassword("sa");
	System.out.println("Data Source Creation");
	return dataSource;
	}

	private Properties getHibernateProperties() 
	{
	System.out.println("Starting of the method getHibernateProperties");
	Properties properties = new Properties();
	properties.setProperty("hibernate.hbm2ddl.auto", "update");
	properties.put("hibernate.show_sql", "true");
	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	System.out.println("Hibernate Properties Implementation");
	return properties;
	}

	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) 
	{
	System.out.println("Starting of the method getSessionFactory");
	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	sessionBuilder.addProperties(getHibernateProperties());
	
	//sessionBuilder.addAnnotatedClasses(Product.class);
	sessionBuilder.addAnnotatedClass(Category.class);
	//sessionBuilder.addAnnotatedClass(Cart.class); 
	//sessionBuilder.addAnnotatedClass(OrderDetail.class);
	System.out.println("Session Factory Implementation");
	return sessionBuilder.buildSessionFactory();
	}
	
	@Bean(name= "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) 
	{
	System.out.println("Starting of the method getTransactionManager");
	HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
	System.out.println("Transaction Implementation");
	return transactionManager;
	}

@Bean(name = "ProductDAO")
public ProductDAO getProductDAO(SessionFactory sessionFactory) 
{
System.out.println("Product DAO Created");
return new ProductDAO(sessionFactory);
}
/*
@Autowired
@Bean(name = "categoryDAO")
public CategoryDAO getCategoryDAO(SessionFactory sessionFactory) 
{
System.out.println("Category DAO Created");
return new CategoryDAO(sessionFactory);
}

@Autowired
@Bean(name = "cartDAO")
public CartDAO getCartDAO(SessionFactory sessionFactory) 
{
System.out.println("Cart DAO Created");
return new CartDAO(sessionFactory);
}

@Autowired
@Bean(name = "OrderDAO")
public OrderDAO getOrderDAO(SessionFactory sessionFactory) 
{
System.out.println("Order DAO Created");
return new OrderDAO(sessionFactory);
}
*/


}