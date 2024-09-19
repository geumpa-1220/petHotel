package com.example.petHotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.petHotel.dto.ReserveDto;
import com.example.petHotel.service.ReserveService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ReserveController {

	
	@Autowired
	private ReserveService service;
	
	
	
	
	@RequestMapping("/reserve/reserve")
	public String reserveView(HttpServletRequest request
			,Model model) {
		
		
		return service.reserveView(request,model);
				
	}
	
	@RequestMapping("/reserve/reserveContent")
	public String reserveContent(HttpServletRequest request,Model model) {
		
		return service.reserveContent(request,model);
	}
	
	@RequestMapping("/reserve/reserveOk")
	public String reserveOk(HttpServletRequest request,HttpSession session,ReserveDto reDto,Model model) {
		
		return service.reserveOk(request,session,reDto,model);
	}
	
	@RequestMapping("reserve/reserveEnd")
	public String reserveEnd(HttpServletRequest request,Model model) {
		
		return service.reserveEnd(request, model);
	}
	
	
	
	
	
	
	
}
