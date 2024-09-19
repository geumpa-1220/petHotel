package com.example.petHotel.service;

import org.springframework.ui.Model;

import com.example.petHotel.dto.ReserveDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public interface ReserveService {
	
    public String reserveView(HttpServletRequest request,Model model);
	
	public String reserveContent(HttpServletRequest request,Model model);
	
	public String reserveOk(HttpServletRequest request,HttpSession session,ReserveDto reDto,Model model);

	public String reserveEnd(HttpServletRequest request,Model model);
}
