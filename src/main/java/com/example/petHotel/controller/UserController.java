package com.example.petHotel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.petHotel.dto.QuestionDto;
import com.example.petHotel.dto.UserDto;
import com.example.petHotel.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/user/signup")
	public String signupForm()
	{
		return "/user/signup";
	}
	@PostMapping("/user/signup")
	public String signup(UserDto userdto)
	{
		userservice.signUp(userdto);
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
		UserDto dto=userservice.login( userdto.getUsername() );
		if( dto != null && dto.getPwd().equals( userdto.getPwd() ) )
		{
			session.setAttribute("id",dto.getId() );
			session.setAttribute("username", dto.getUsername() );
			session.setAttribute("role", dto.getRole() );
			return "redirect:/main/index";
		}
		else
		{
			 model.addAttribute("userdto", userdto);
		     model.addAttribute("error", "Invalid username or password.");
			return "/user/login";
		}
		
	}
	
	@GetMapping("/user/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/main/index";
	}
	
	@GetMapping("/user/mypage")
	public String mypage()
	{
		return "/user/mypage";
	}
	
	
	@GetMapping("/user/update")
	public String updateForm()
	{
		return "/user/update";
	}
	@PostMapping("/user/update")
	public String update(UserDto userdto,HttpSession session)
	{
		Integer id=(Integer)session.getAttribute("id");
		userdto.setId(id);
		userservice.update(userdto);
		
		session.setAttribute("username", userdto.getUsername());
		
		return "redirect:/user/mypage";
	}
	
	@GetMapping("/user/delete")
	public String delete(HttpSession session )
	{
		int id=(int) session.getAttribute("id");
		userservice.deleteUser(id);
		session.invalidate();
		return "/main/index";
	}
	
	
	
	
	
	
	

	
}
