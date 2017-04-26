package com.niit.ShoppingCartBackEnd;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCartBackEnd.DAO.UserDAO;
import com.niit.ShoppingCartBackEnd.domain.User;

public class UserDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired
	static UserDAO userDAO;
	@Autowired
	static User user;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.ShoppingCartBackEnd.domain.DAOImpl");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
		user = (User) context.getBean("user");

	}

	@Test

	public void createUserTestCase() {
		user.setId("suveen");
		user.setName("suveen");
		user.setPassword("sna123");
		user.setContact("52468976");
		user.setRole("ROLE_User");
		boolean flag = userDAO.save(user);
		assertEquals("createUserTestCase", true, flag);
	}
	

@Test
	public void updateUserTestCase() {
		user.setId("suveen");
		user.setName("suveen");
		user.setPassword("sna123");
		user.setContact("52468976");
		user.setRole("ROLE_User");
		boolean flag = userDAO.update(user);
		assertEquals("updateUserTestCase", true, flag);
	}

@Test
	public void validateUserTestCase() {
	boolean flag=userDAO.validate("suveen", "sna123");
	
		assertEquals( true, flag);
	}

@Test
public void getAllUserTestCase()
{
	int actualsize=userDAO.list().size();
	assertEquals(12, actualsize);
}
}
