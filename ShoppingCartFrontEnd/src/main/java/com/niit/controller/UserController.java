package com.niit.controller;

	import org.springframework.beans.factory.*;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.servlet.ModelAndView;

	import com.niit.ShoppingCartBackEnd.DAO.*;
	import com.niit.ShoppingCartBackEnd.domain.*;

	@Controller
	public class UserController {

		@Autowired UserDAO userDAO;
		@Autowired	User user;

		@RequestMapping("/validate")
		public ModelAndView login(@RequestParam("userName") String id, 
				@RequestParam("password") String password) 
		{
			
				ModelAndView mv = new ModelAndView("/Home");
			
			if (userDAO.validate(id, password) == true) {
				user = userDAO.get(id);
				mv.addObject("Message", "Welcome" + user.getName());

			} else {

				mv.addObject("message", "invalid credencials..please try again");
			}
			return mv;
		}
	}
	

