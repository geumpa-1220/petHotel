package com.example.petHotel.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.petHotel.dto.QuestionDto;
import com.example.petHotel.service.QuestionService;


import jakarta.servlet.http.HttpSession;
@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionservice;
	
	
	@GetMapping("/question/list")
	public String qnalist( Model model, HttpSession session)
	{
		Integer userid = (Integer)session.getAttribute("userid");
		ArrayList<QuestionDto> questionDtoList = questionservice.questions(userid);
		
		model.addAttribute("questionList",questionDtoList);
		
		return "/question/list";
	}

}
