package com.example.petHotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.petHotel.dto.AdminDto;
import com.example.petHotel.service.AdminService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@GetMapping("/admin/login")
	public String loginForm()
	{
		return "/admin/login";
	}
	@PostMapping("/admin/login")
	public String loginOk(AdminDto adminDto , HttpSession session , Model model )
	{
		String username=adminDto.getUsername();
		AdminDto dbDto=service.login(username);
		
		if( dbDto != null && dbDto.getPwd().equals( adminDto.getPwd() ) )
		{
			session.setAttribute("username", dbDto.getUsername());
			session.setAttribute("id", dbDto.getId());
			session.setAttribute("role", dbDto.getRole());
			return "/main/index";
		}
		else
		{
			model.addAttribute("error", "Invalid username or password.");
			model.addAttribute("admindto", adminDto);
			return "/admin/login";
		}
		
	}
	
	@GetMapping("/admin/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/main/index";
	}
	
	@GetMapping("/admin/mypage")
	public String mypage()
	{
		return "/admin/mypage";
	}
	
	@GetMapping("/admin/update")
	public String updateForm()
	{
		return "/admin/update";
	}
	@PostMapping("/admin/update")
	public String update(AdminDto adminDto , HttpSession session)
	{
		int id = (int) session.getAttribute("id");
		adminDto.setId(id);
		service.update(adminDto);
		
		session.setAttribute("username", adminDto.getUsername());
		return "/admin/mypage";
	}
	
	@GetMapping("/admin/delete")
	public String delete(HttpSession session)
	{
		int id =(int) session.getAttribute("id");
		service.delete(id);
		
		session.invalidate();
		
		return "/main/index";
	}
	
	
	
	
	
	
	
	
	

}
