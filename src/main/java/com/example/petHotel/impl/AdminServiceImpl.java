package com.example.petHotel.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.petHotel.dto.AdminDto;
import com.example.petHotel.mapper.AdminMapper;
import com.example.petHotel.service.AdminService;

import jakarta.servlet.http.HttpSession;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public String adminLogin(AdminDto adminDto , HttpSession session , Model model)
	{
		String username=adminDto.getUsername();
		AdminDto dbDto=adminMapper.adminLogin(username);
		
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
	
	@Override
	public String updateAdmin(AdminDto adminDto , HttpSession session)
	{
		int id = (int) session.getAttribute("id");
		adminDto.setId(id);
		adminMapper.updateAdmin(adminDto);
		
		session.setAttribute("username", adminDto.getUsername());
		return "/admin/mypage";
	}
	
	@Override
	public void deleteAdmin(int id)
	{
		adminMapper.deleteAdmin(id);
	}
	

}











