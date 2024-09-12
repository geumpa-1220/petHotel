package com.example.petHotel.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.petHotel.dto.AdminDto;

@Mapper
public interface AdminMapper {
	
	AdminDto adminLogin(String username);
    void updateAdmin(AdminDto adminDto);
    void deleteAdmin(int id);
}
