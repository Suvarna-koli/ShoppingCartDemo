package com.niit.Mobitel.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.*;

public class ProductDAO {

	@Autowired
	SessionFactory sessionfactory;
	
	public ProductDAO(SessionFactory sessionfactory)
	{
		this.sessionfactory=sessionfactory;
		
	
	}
}

