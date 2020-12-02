package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dao.UserDao;
import com.example.model.User;
import com.example.service.UserService;

@Controller
public class MyController {

	@Autowired
	private UserService userservice;

	@ModelAttribute
	public String forall(Model model) {
		model.addAttribute("title", "Log-In Form");
		return "";
	}

	@RequestMapping("/register")
	public String register() {

		return "register";
	}

	@RequestMapping("/success")
	public String success(@ModelAttribute User user, Model model) {
		model.addAttribute("emailid", user.getEmail());
		this.userservice.create(user);
		return "success";
	}

	@RequestMapping("/login")
	public String from() {
		return "form";
	}

	@RequestMapping("/Onlogin")
	public String login(@ModelAttribute User user , Model m )
	{
		
		User us=this.userservice.validation(user);
		if(us!=null)
		{	
			return "loginsuccess";
		}
		else
		{return "index";}
				
	}
	
	
}
