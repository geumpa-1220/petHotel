package com.example.petHotel.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.petHotel.dto.QnaDto;
import com.example.petHotel.dto.QuestionDto;
@Mapper
public interface QuestionMapper {

	ArrayList<QuestionDto> questionList();
	void qinsert(QuestionDto questionDto);
	void qdelete(int questionId);
	QnaDto getQnaContent(int id);
	
}
