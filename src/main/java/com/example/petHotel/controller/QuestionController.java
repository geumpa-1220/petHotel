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
	private QuestionService questionservice;
	
	
	@GetMapping("/question/list")
	public String qnalist( Model model, HttpSession session)
	{
		int userid = (int) session.getAttribute("id");
		ArrayList<QuestionDto> questionDtoList = questionservice.questions(userid);
		
		if (questionDtoList == null)
		{
			questionDtoList = new ArrayList<>();
		}
		model.addAttribute("questionList",questionDtoList);

	    
		
		return "/question/list";
	}
	
	@GetMapping("/question/write")
	public String writeForm()
	{
		return "/question/write";
	}
	@PostMapping("/writeOk")
	public String write(QuestionDto questionDto,HttpSession session)
	{
		int userid = (int)session.getAttribute("id");
		questionDto.setUserid(userid);
		questionservice.qinsert(questionDto);
		
		return "redirect:/question/list";
	}
	
	@PostMapping("/question/delete")
	public String delete(@RequestParam("questionId") int questionId)
	{
		questionservice.qdelete(questionId);
		
		return "redirect:/question/list";
	}
	
	@GetMapping("/question/content")
	public String content(Model model,@RequestParam("id") int id)
	{
		QnaDto contents = questionservice.getQnaContent(id);
		model.addAttribute("content", contents);
		
		return "/question/content";
	}

}
