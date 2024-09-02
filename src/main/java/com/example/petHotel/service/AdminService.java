package com.example.petHotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.petHotel.dto.AdminDto;
import com.example.petHotel.mapper.AdminMapper;

@Service
public class AdminService {
	@Autowired
	private AdminMapper mapper;
	
	public AdminDto login(String username)
	{
		return mapper.login(username);
	}
	
	public void update(AdminDto adminDto)
	{
		mapper.update(adminDto);
	}
	
	public void delete(int id)
	{
		mapper.delete(id);
	}

}
