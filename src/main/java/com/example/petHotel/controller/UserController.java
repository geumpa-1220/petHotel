package com.example.petHotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.petHotel.dto.UserDto;
import com.example.petHotel.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/user/signup")
	public String signupForm()
	{
		return "/user/signup";
	}
	@PostMapping("/user/signup")
	public String signup(UserDto userdto)
	{
		service.signUp(userdto);
		return "redirect:/user/login";
	}
	
	@GetMapping("/user/login")
	public String loginForm()
	{
		return "/user/login";
	}
	@PostMapping("/user/login")
	public String login(UserDto userdto , HttpSession session,Model model)
	{
		UserDto db_dto=service.login( userdto.getUsername() );
		if( db_dto != null && db_dto.getPwd().equals( userdto.getPwd() ) )
		{
			session.setAttribute("user",db_dto.getId());
			return "redirect:/main/index";
		}
		else
		{
			 model.addAttribute("userdto", userdto);
		     model.addAttribute("error", "Invalid username or password.");
			return "/user/login";
		}
		
	}
	

	
}
