package com.example.petHotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.petHotel.dto.QuestionDto;
import com.example.petHotel.dto.UserDto;
import com.example.petHotel.mapper.UserMapper;

import jakarta.servlet.http.HttpSession;


public interface UserService {
	
	
	
	public void signUp(UserDto userDto);
	public String login(UserDto userDto , HttpSession session , Model model);
	public String update(UserDto userdto , HttpSession session);
	public void deleteUser(HttpSession session);
	
	
}
