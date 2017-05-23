package controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String GotoIndex()
	{
		return "Home";
	}
		/*public ModelAndView goToHome() {
		ModelAndView mv=new ModelAndView("Home");
		mv.addObject("massage","Thankew for visiting shopping cart ");
		//model.addAttribute("message", "Thankew for visiting shopping cart ");
		//return "Home";
		return mv;
	}*/
	@RequestMapping("/LoginPage")
	public String GotoLoginPage()
	{
		return "Login";
	}
	
	@RequestMapping("/RegistrationPage")
	public String GotoRegisterPage()
	{
		return "Register";
	}
	
	
	

}
