package com.niit.ShoppingCartBackEnd.DAO;

import java.util.List;

import com.niit.ShoppingCartBackEnd.domain.Category;

public interface CategoryDAO {
	// get all category
	// create, update, delete, get category by id, get category by name.
	public List<Category> list();

	public boolean save(Category category);

	public boolean update(Category category);

	public boolean delete(String id);

	public Category getCategoryByID(String id);

	public Category getCategoryByName(String name);
}
