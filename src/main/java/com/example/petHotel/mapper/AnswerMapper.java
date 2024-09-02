package com.example.petHotel.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.petHotel.dto.QnaDto;

@Mapper
public interface AnswerMapper {
	
	ArrayList<QnaDto> getAdminQna();
	QnaDto getQnaById(int id);
	void write();

}
