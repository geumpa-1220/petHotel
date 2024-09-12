package com.example.petHotel.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.petHotel.dto.QnaDto;
import com.example.petHotel.dto.QuestionDto;
import com.example.petHotel.service.QuestionService;


import jakarta.servlet.http.HttpSession;
@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	
	@GetMapping("/question/list")
	public String questionList( Model model)
	{
		return questionService.questionList(model);
	}
	
	@GetMapping("/question/write")
	public String writeForm()
	{
		return "/question/write";
	}
	@PostMapping("/writeOk")
	public String writeQuestion(QuestionDto questionDto,HttpSession session)
	{
		return questionService.writeQuestion(questionDto, session);
	}
	
	
	@PostMapping("/question/delete")
	public String delete(@RequestParam("questionId") int questionId)
	{
		questionService.deleteQuestion(questionId);
		
		return "redirect:/question/list";
	}
	
	@GetMapping("/question/content")
	public String content(Model model,@RequestParam("id") int id)
	{
		return questionService.getQnaContent(model, id);
	}

}
