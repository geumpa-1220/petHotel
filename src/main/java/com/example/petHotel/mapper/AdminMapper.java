package com.example.petHotel.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.petHotel.dto.AdminDto;

@Mapper
public interface AdminMapper {
	
	AdminDto login(String username);
    void update(AdminDto adminDto);
    void delete(int id);
}
