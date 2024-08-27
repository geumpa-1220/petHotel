package com.example.petHotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.petHotel.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	

}
