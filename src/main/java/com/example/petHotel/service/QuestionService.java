package com.example.petHotel.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petHotel.dto.QnaDto;
import com.example.petHotel.dto.QuestionDto;
import com.example.petHotel.mapper.QuestionMapper;

@Service
public class QuestionService {

	@Autowired
	private QuestionMapper mapper;
	
	public ArrayList<QuestionDto> questions( int userid)
	{
		return mapper.questions(userid);
	}
	
	public void qinsert(QuestionDto questionDto)
	{
		mapper.qinsert(questionDto);
	}
	
	public void qdelete(int questionId)
	{
		mapper.qdelete(questionId);
	}
	
	public QnaDto getQnaContent(int id)
	{
		return mapper.getQnaContent(id);
	}
}
