package com.example.petHotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petHotel.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper mapper;

}
