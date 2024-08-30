package com.example.petHotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.petHotel.dto.QuestionDto;
import com.example.petHotel.dto.UserDto;
import com.example.petHotel.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/user/signup")
	public String signupForm()
	{
		return "/user/signup";
	}
	@PostMapping("/user/signup")
	public String signup(UserDto userdto)
	{
		service.signUp(userdto);
		return "redirect:/user/login";
	}
	
	@GetMapping("/user/login")
	public String loginForm()
	{
		return "/user/login";
	}
	@PostMapping("/user/login")
	public String login(UserDto userdto , HttpSession session,Model model)
	{
		UserDto db_dto=service.login( userdto.getUsername() );
		if( db_dto != null && db_dto.getPwd().equals( userdto.getPwd() ) )
		{
			session.setAttribute("userid",db_dto.getId() );
			session.setAttribute("username", db_dto.getUsername() );
			session.setAttribute("role", db_dto.getRole() );
			return "redirect:/main/index";
		}
		else
		{
			 model.addAttribute("userdto", userdto);
		     model.addAttribute("error", "Invalid username or password.");
			return "/user/login";
		}
		
	}
	
	@GetMapping("/user/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/main/index";
	}
	
	@GetMapping("/user/mypage")
	public String myquestions(QuestionDto questionDto,Model model, HttpSession session)
	{
		Integer userid = (Integer)session.getAttribute("userid");
		questionDto = service.questions(userid);
		
		model.addAttribute("title", questionDto.getTitle());
		model.addAttribute("time",questionDto.getQtime());
		
		return "/user/mypage";
	}
	
	@GetMapping("/user/qna")
	public String qna(QuestionDto questionDto,Model model, HttpSession session)
	{
		Integer userid = (Integer)session.getAttribute("userid");
		questionDto = service.questions(userid);
		
		model.addAttribute("title", questionDto.getTitle());
		model.addAttribute("time",questionDto.getQtime());
		
		return "/user/qna";
	}

	
}
