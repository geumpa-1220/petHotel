package com.example.petHotel.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.petHotel.dto.QuestionDto;
@Mapper
public interface QuestionMapper {

	ArrayList<QuestionDto> questions(int userid);
}
