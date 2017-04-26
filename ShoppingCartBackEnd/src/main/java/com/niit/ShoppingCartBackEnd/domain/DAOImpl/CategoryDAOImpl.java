package com.niit.ShoppingCartBackEnd.domain.DAOImpl;

import java.util.List;

import javax.management.Query;
import javax.transaction.Transactional;
import javax.websocket.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ShoppingCartBackEnd.DAO.CategoryDAO;
import com.niit.ShoppingCartBackEnd.domain.Category;

@Repository("categoryDAO") // to create the singleton instance
// CategoryDAOImpl categorydao=new categoryDAOImpl
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override

	public List<Category> list() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("From Category").list();

	}

	@Override
	public boolean save(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}
		return true;
	}

	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}
		return true;
	}

	@Override
	public boolean delete(String id) {
		 try{
				sessionFactory.getCurrentSession().delete(getCategoryByID(id));
	}

	catch(	Exception e)
	{
		e.printStackTrace();
		return false;
	}
		 return true;
	}

	@Override
	public Category getCategoryByID(String id)
	//id is primary key so thats y it is return like this and not using qury
	{

		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}

	@Override
	public Category getCategoryByName(String name) {
		return (Category)sessionFactory.getCurrentSession().createQuery("from Category where name=?")
		.setString(0,name).uniqueResult();
		
		/*Query query=(Query) sessionFactory.getCurrentSession().createQuery("from Category where name=?");
((org.hibernate.Query) query).setString(0,name);
return (Category)((org.hibernate.Query) query).uniqueResult();
*/}
}
