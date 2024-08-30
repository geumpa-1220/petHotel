package com.example.petHotel.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
