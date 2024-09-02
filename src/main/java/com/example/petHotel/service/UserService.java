package com.example.petHotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petHotel.dto.QuestionDto;
import com.example.petHotel.dto.UserDto;
import com.example.petHotel.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper mapper;
	
	public void signUp(UserDto userdto)
	{
		mapper.insertUser(userdto);
	}

	public UserDto login(String username)
	{
		return mapper.getuser(username);
	}
	
	public void update(UserDto userdto)
	{
		 mapper.update(userdto);
	}
	
	public void deleteUser(int id)
	{
		mapper.deleteUser(id);
	}
	
}
