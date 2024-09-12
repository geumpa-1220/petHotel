package com.example.petHotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.petHotel.dto.AdminDto;


import com.example.petHotel.mapper.AdminMapper;

import jakarta.servlet.http.HttpSession;


public interface AdminService {
	
	
	public String adminLogin(AdminDto adminDto , HttpSession session , Model model);
	public String updateAdmin(AdminDto adminDto ,HttpSession session);
	public void deleteAdmin(int id);
	

}
