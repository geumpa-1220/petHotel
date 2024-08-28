package com.example.petHotel.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.petHotel.dto.UserDto;

@Mapper
public interface UserMapper {
	
	void insertUser(UserDto userdto);
	UserDto getuser(String username);

}
