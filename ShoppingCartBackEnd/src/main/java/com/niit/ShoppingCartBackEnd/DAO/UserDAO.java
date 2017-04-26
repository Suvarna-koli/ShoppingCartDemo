package com.niit.ShoppingCartBackEnd.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.ShoppingCartBackEnd.domain.*;

public interface UserDAO {
/*	@Autowired
	SessionFactory sessionfactory;
	
	public UserDAO(SessionFactory sessionfactory)
	{
		this.sessionfactory=sessionfactory;
		
	
	}
*/
	public boolean save(User user);

	public boolean update(User user);

	public boolean validate(String id, String password);

	public List<User> list();

	public User get(String id);

}
