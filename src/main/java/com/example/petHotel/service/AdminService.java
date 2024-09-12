package com.example.petHotel.service;


import org.springframework.ui.Model;

import com.example.petHotel.dto.AdminDto;




import jakarta.servlet.http.HttpSession;


public interface AdminService {
	
	
	public String adminLogin(AdminDto adminDto , HttpSession session , Model model);
	public String updateAdmin(AdminDto adminDto ,HttpSession session);
	public void deleteAdmin(int id);
	

}
