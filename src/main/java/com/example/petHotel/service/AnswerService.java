package com.example.petHotel.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.petHotel.dto.AnswerDto;
import com.example.petHotel.dto.QnaDto;
import com.example.petHotel.mapper.AnswerMapper;


public interface AnswerService {
	
	
	
	public String getAdminQna(Model model);
	public String getQnaById(int id , Model model);
	public String writeAnswer( AnswerDto answerDto );
	
	

}
