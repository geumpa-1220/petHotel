package com.example.petHotel.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.petHotel.dto.QnaDto;
import com.example.petHotel.dto.QuestionDto;
import com.example.petHotel.mapper.QuestionMapper;
import com.example.petHotel.service.QuestionService;

import jakarta.servlet.http.HttpSession;

@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionMapper questionMapper;
	
	
	@Override
	public String questionList(Model model)
	{
		ArrayList<QuestionDto> questionDtoList =questionMapper.questionList();
		
		if (questionDtoList == null)
		{
			questionDtoList = new ArrayList<>();
		}
		
		model.addAttribute("questionList",questionDtoList);

		return "/question/list";
	}

	
	@Override
	public String writeQuestion(QuestionDto questionDto , HttpSession session)
	{
		int userid = (int)session.getAttribute("id");
		String username =(String) session.getAttribute("username");
		questionDto.setUserid(userid);
		questionDto.setUsername(username);
		questionMapper.qinsert(questionDto);
		
		return "redirect:/question/list";
	}
	
	@Override
	public void deleteQuestion(int questionId)
	{
		questionMapper.qdelete(questionId);
	}
	
	
	@Override
	public String getQnaContent(Model model , int id)
	{
		QnaDto contents = questionMapper.getQnaContent(id);
		model.addAttribute("content", contents);
		
		return "/question/content";
	}
}









