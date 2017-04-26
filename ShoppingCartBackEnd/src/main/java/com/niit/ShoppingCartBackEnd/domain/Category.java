package com.niit.ShoppingCartBackEnd.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Category {
	@Id
	private String id;
	
	private String name;
	private String description;

}
