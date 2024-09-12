package com.example.petHotel.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.petHotel.dto.AnswerDto;
import com.example.petHotel.service.AnswerService;

@Controller
public class AnswerController {
	
	@Autowired
	private AnswerService answerService;
	
	@GetMapping("/answer/list")
	public String qnaList(Model model)
	{	
		return answerService.getAdminQna(model);
	}

	@GetMapping("/answer/content")
	public String content(@RequestParam("id") int id ,Model model)
	{
		return answerService.getQnaById(id, model);
	}
	
	@PostMapping("/answer/write")
	public String writeAnswer(AnswerDto answerDto)
	{
		return answerService.writeAnswer(answerDto);
	}
	
	
	
	
	
}
