package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String IndexPage() {
		return "index";
	}

	@RequestMapping("/Home")
	public String HomePage() {
		return "Home";
	}
}