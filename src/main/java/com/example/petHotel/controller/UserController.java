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
	private UserService userService;
	
	@GetMapping("/user/signup")
	public String signupForm()
	{
		return "/user/signup";
	}
	@PostMapping("/user/signup")
	public String signup(UserDto userDto)
	{
		userService.signUp(userDto);
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
		return userService.login(userdto, session, model);
	}
	
	@GetMapping("/user/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/main/index";
	}
	
	//예약정보 들어올 예정
	@GetMapping("/user/mypage")
	public String mypageForm()
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
		return userService.update(userdto, session);
	}
	
	@GetMapping("/user/delete")
	public String delete(HttpSession session )
	{
		userService.deleteUser(session);
		return "redirect:/main/index";
	}
	
	
	
	
	
	
	

	
}
