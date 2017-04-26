package com.niit.controller;

import java.util.List;


import java.util.Locale.Category;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingCartBackEnd.DAO.*;
import com.niit.ShoppingCartBackEnd.domain.*;

@Controller
public class HomeController {

	@Autowired
	HttpSession session;
	@Autowired
	Category category;
	@Autowired CategoryDAO categoryDAO;

	@RequestMapping("/")
	public ModelAndView goToHome() {
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("massage", "Thankew for visiting shopping cart ");
		// model.addAttribute("message", "Thankew for visiting shopping cart ");
		// return "Home";
		List<com.niit.ShoppingCartBackEnd.domain.Category> categorylist = categoryDAO.list();

		session.setAttribute("categoryList", categorylist);
		session.setAttribute("category", category);
		return mv;
	}

	@RequestMapping("/LoginPage")
	public String LoginPage(Model model) {
		model.addAttribute("isUserClickedLogin", "true");
		System.out.println("user clicked login page");
		return "Login";
	}

	@RequestMapping("/RegistrationPage")
	public String RegistrationPage(Model model)

	{
		model.addAttribute("isUserClickedRegister", "true");
		System.out.println("user clicked in register page");
		return "Registration";
	}

}
