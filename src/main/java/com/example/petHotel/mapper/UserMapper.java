package com.example.petHotel.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.petHotel.dto.QuestionDto;
import com.example.petHotel.dto.UserDto;

@Mapper
public interface UserMapper {
	
	void insertUser(UserDto userdto);
	UserDto login(String username);
	void update(UserDto userdto);
	void deleteUser(int id);
	ArrayList<QuestionDto> myQuestionList(int userid);

}
