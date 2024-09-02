package com.example.petHotel.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petHotel.dto.QnaDto;
import com.example.petHotel.mapper.AnswerMapper;

@Service
public class AnswerService {
	
	@Autowired
	private AnswerMapper mapper;
	
	public ArrayList<QnaDto> getAdminQna()
	{
		return mapper.getAdminQna();
	}
	
	public QnaDto getQnaById(int id)
	{
		return mapper.getQnaById(id);
	}
	
	public void write(  )
	{
		mapper.write();
	}
	

}
