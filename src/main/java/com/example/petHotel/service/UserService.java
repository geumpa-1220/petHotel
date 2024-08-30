package com.example.petHotel.service;

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
	
	public QuestionDto questions( int userid)
	{
		return mapper.questions(userid);
	}
}
