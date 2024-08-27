package com.example.petHotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	@GetMapping("/")
	public String home()
	{
		return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String index() 
	{
		return "index";
	}
	

}
