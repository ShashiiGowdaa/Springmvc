package com.springmvc.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.demo.beans.Login;

@Controller
public class MyController {
	
	@RequestMapping("/greet")
	public ModelAndView processRequest()
	{
		String modelObject="A Greet Message: Hello Everyone!!!";
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("mo", modelObject);
		mv.setViewName("view1");
		
		return mv;
	}
	@RequestMapping("/login")
	public ModelAndView processLoginRequest()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping("/authenticate")
	public ModelAndView processAuthenticate(@ModelAttribute("loginDetails") Login login)
	{
		ModelAndView mv=new ModelAndView();
		
	/*	Login login=new Login();
		login.setUsername(user);
		login.setPwd(pwd);*/
		
		//mv.addObject("loginDetails", login);
		
		if(login.getUsername().equals("shashi") && login.getPwd().equals("12345"))
			mv.addObject("message","User is Authenticated!!!");
		else
			mv.addObject("message","User is not Authenticated!!!");
		
		mv.setViewName("response");
		return mv;
	}

}
