package com.example.petHotel.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.petHotel.dto.AnswerDto;
import com.example.petHotel.dto.QnaDto;
import com.example.petHotel.mapper.AnswerMapper;
import com.example.petHotel.service.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService{
	@Autowired
	private AnswerMapper answerMapper;
	
	@Override
	public String getAdminQna(Model model)
	{
		ArrayList<QnaDto> qnadto = answerMapper.getAdminQna();
		model.addAttribute("allList", qnadto);
		
		return "/answer/list";
	}
	
	@Override
	public String getQnaById(int id , Model model)
	{
		QnaDto qnadto = answerMapper.getQnaById(id);
		model.addAttribute("content", qnadto);
		
		return "/answer/content";
	}
	
	@Override
	public String writeAnswer(AnswerDto answerDto)
	{
        answerMapper.writeAnswer(answerDto);
		
		return "redirect:/answer/list";
	}

}







