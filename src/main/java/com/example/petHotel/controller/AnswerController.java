package com.example.petHotel.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.petHotel.dto.AnswerDto;
import com.example.petHotel.dto.QnaDto;
import com.example.petHotel.service.AnswerService;

@Controller
public class AnswerController {
	
	@Autowired
	private AnswerService service;
	
	@GetMapping("/answer/list")
	public String qnaList(Model model)
	{
		ArrayList<QnaDto> qnadto = service.getAdminQna();
		model.addAttribute("allList", qnadto);
		
		return "/answer/list";
	}

	@GetMapping("/answer/content")
	public String content(@RequestParam("id") int id ,Model model)
	{
		QnaDto qnadto = service.getQnaById(id);
		model.addAttribute("content", qnadto);
		
		return "/answer/content";
	}
	
	@PostMapping("/answer/write")
	public String write(AnswerDto answerDto)
	{
		service.write(answerDto);
		
		return "redirect:/answer/list";
	}
	
	
	
	
	
}
