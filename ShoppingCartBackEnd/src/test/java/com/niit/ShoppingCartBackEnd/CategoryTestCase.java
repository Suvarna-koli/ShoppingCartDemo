package com.niit.ShoppingCartBackEnd;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCartBackEnd.DAO.CategoryDAO;
import com.niit.ShoppingCartBackEnd.domain.Category;

import java.lang.*;

public class CategoryTestCase {
//because we used annotations @Repository,@Component,@Configuration
	@Autowired static AnnotationConfigApplicationContext context;
	@Autowired static CategoryDAO categoryDAO;
	@Autowired static Category category;
	@Test
	@BeforeClass
	public static void init() {

	context=new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	categoryDAO=(CategoryDAO) context.getBean("categoryDAO");//need to do typecasting here	category=(Category)context.getBean("category");
	}
	
	@Test
	public void getAllCategoresTestCase()
	{
		List<Category> categories= categoryDAO.list();
		assertEquals(1,categories.size());
	}

}
