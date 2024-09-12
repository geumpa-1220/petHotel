package com.example.petHotel.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.petHotel.dto.QuestionDto;
import com.example.petHotel.dto.UserDto;
import com.example.petHotel.mapper.UserMapper;
import com.example.petHotel.service.UserService;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void signUp(UserDto userDto)
	{
		userMapper.insertUser(userDto);
	}

	@Override
	public String login(UserDto userDto , HttpSession session , Model model)
	{
		UserDto dto=userMapper.login( userDto.getUsername() );
		if( dto != null && dto.getPwd().equals( userDto.getPwd() ) )
		{
			session.setAttribute("id",dto.getId() );
			session.setAttribute("username", dto.getUsername() );
			session.setAttribute("role", dto.getRole() );
			return "redirect:/main/index";
		}
		else
		{
			 model.addAttribute("userdto", userDto);
		     model.addAttribute("error", "Invalid username or password.");
			return "/user/login";
		}
		
	}
	
	@Override
	public String update(UserDto userDto , HttpSession session)
	{
		Integer id=(Integer)session.getAttribute("id");
		userDto.setId(id);
		userMapper.update(userDto);
		
		session.setAttribute("username", userDto.getUsername());
		
		return "redirect:/user/mypage";
	}
	
	@Override
	public void deleteUser(HttpSession session)
	{
		int id=(int) session.getAttribute("id");
		userMapper.deleteUser(id);
		session.invalidate();
	}
	
	@Override
	public String myQuestionList(Model model,HttpSession session)
	{
		int userid=(int)session.getAttribute("id");
		ArrayList<QuestionDto> qDtoList=userMapper.myQuestionList(userid);
		model.addAttribute("myQuestionList", qDtoList);
		
		return "/user/mypage";
	}
}




