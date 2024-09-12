package com.example.petHotel.service;




import org.springframework.ui.Model;


import com.example.petHotel.dto.QuestionDto;


import jakarta.servlet.http.HttpSession;


public interface QuestionService {

	
	
	public String questionList(Model model );
	public String writeQuestion(QuestionDto questionDto , HttpSession session);
	public void deleteQuestion(int questionId);
	public String getQnaContent(Model model,int id);

}
