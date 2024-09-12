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
	private AdminService adminService;
	
	@GetMapping("/admin/login")
	public String loginForm()
	{
		return "/admin/login";
	}
	@PostMapping("/admin/login")
	public String loginOk(AdminDto adminDto , HttpSession session , Model model )
	{
		return adminService.adminLogin(adminDto , session , model);
	}
	
	
	@GetMapping("/admin/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/main/index";
	}
	
	
	
	@GetMapping("/admin/mypage")
	public String mypageForm()
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
		return adminService.updateAdmin(adminDto, session);
	}
	
	@GetMapping("/admin/delete")
	public String deleteAdmin(HttpSession session)
	{
		int id =(int) session.getAttribute("id");
		adminService.deleteAdmin(id);
		session.invalidate();
		
		return "/main/index";
	}
	
	
	
	
	
	
	
	
	

}
