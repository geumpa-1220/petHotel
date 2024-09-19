package com.example.petHotel.impl;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.petHotel.dto.ReserveDto;
import com.example.petHotel.dto.RoomDto;
import com.example.petHotel.mapper.ReserveMapper;
import com.example.petHotel.service.ReserveService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class ReserveServicelmpl implements ReserveService {

	@Autowired
	private ReserveMapper mapper;
	
	@Override
	public String reserveView(HttpServletRequest request,Model model) {
		
		
		int year,month;
		if(request.getParameter("year")==null)
		{
			LocalDate today=LocalDate.now();
			year=today.getYear();
			month=today.getMonthValue();
		}
		else 
		{			
			year=Integer.parseInt(request.getParameter("year"));
			month=Integer.parseInt(request.getParameter("month"));
			
			if(month==0) 
			{
			    year=year-1;
			    month=12;
			}
			
			if(month==13)
			{
				year=year+1;
				month=1;
			}
		}
		
		LocalDate xday = LocalDate.of(year, month, 1);
		
		int yoil =xday.getDayOfWeek().getValue();
		
		if(yoil ==7) {
			
			yoil = 0;
		}
		
		int lastday = xday.lengthOfMonth();
		
		int ju = (int)Math.ceil((yoil+lastday)/7.0);
		int day= 1;
		
		 int nextYear = (month == 12) ? year + 1 : year;
		  int nextMonth = (month == 12) ? 1 : month + 1;
		 LocalDate nextMonthDate = LocalDate.of(nextYear, nextMonth, 1);
		 int nextYoil = nextMonthDate.getDayOfWeek().getValue();
		    if (nextYoil == 7) {
		        nextYoil = 0; // 일요일을 0으로 설정
		    }
		 int nextLastDay = nextMonthDate.lengthOfMonth();
		 int juNext = (int) Math.ceil((nextYoil + nextLastDay) / 7.0);
		
		ArrayList<RoomDto> rdto =mapper.getRoom();
		model.addAttribute("yoil",yoil);
		model.addAttribute("lastday",lastday);
		model.addAttribute("ju",ju);
		
		model.addAttribute("year",year);
		model.addAttribute("month",month);
		model.addAttribute("day",day);

		model.addAttribute("rdto",rdto);
		
		model.addAttribute("nextYear",nextYear);
		model.addAttribute("nextMonth",nextMonth);
		model.addAttribute("nextYoil",nextYoil);
		model.addAttribute("nextLastDay",nextLastDay);
		model.addAttribute("juNext",juNext);
		return "/reserve/reserve";
	}
	
	
	@Override
	public String reserveContent(HttpServletRequest request,Model model) {
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		int dayDiff =Integer.parseInt(request.getParameter("dayDifference"));
		String roomid = request.getParameter("roomid");
		
		    RoomDto rdto = mapper.reserveContent(roomid);
		   
		    model.addAttribute("rdto", rdto);
		    model.addAttribute("dayDiff",dayDiff);
		    model.addAttribute("startDate",startDate);
		    model.addAttribute("endDate",endDate);
		    model.addAttribute("roomid",roomid);
		    
		    
		    
		
		
		return "/reserve/reserveContent";
	}
	
	@Override
	public String reserveOk(HttpServletRequest request,HttpSession session,ReserveDto reDto,Model model) {
		
	 	 String username = session.getAttribute("username").toString();
		 String startDateParam = request.getParameter("startDate");
		 String endDateParam = request.getParameter("endDate");
		 String content = request.getParameter("content");
		 String phone = request.getParameter("phone");
		 int petsu = Integer.parseInt(request.getParameter("petsu"));
		 String chongprice = request.getParameter("chongprice");
		 
		 LocalDate endDate = LocalDate.parse(endDateParam);
		 LocalDate startDate = LocalDate.parse(startDateParam);
		 String roomid = request.getParameter("roomid");
		 String rNum1 = phone.substring(phone.length()-2);
		 String rNum2 = startDateParam.substring(5, 7) + startDateParam.substring(8, 10);
		 String rNum3 = endDateParam.substring(5, 7) + endDateParam.substring(8, 10);
		 
		 String reserveNum = roomid+rNum1+rNum2+rNum3;
		 
		 if (startDate.isAfter(endDate)) {
			   
			    LocalDate tempDate = startDate;
			    startDate = endDate;
			    endDate = tempDate;
			}
		
		 reDto = new ReserveDto();
		 reDto.setChongprice(chongprice);
		 reDto.setPetsu(petsu);
		 reDto.setPhone(phone);
		 reDto.setContent(content);
		 reDto.setEndDate(endDate);
		 reDto.setStartDate(startDate);	
		 reDto.setUsername(username);
		 reDto.setRoomid(roomid);
		 reDto.setReserveNum(reserveNum);
		 
		 mapper.reserveOk(reDto);
		
		/* -> FROM reserve
		    -> WHERE roomid = 1
		    ->   AND (startDate BETWEEN '2024-09-23' AND '2024-09-25'
		    ->        OR endDate BETWEEN '2024-09-23' AND '2024-09-25'
		    ->        OR (startDate <= '2024-09-23' AND endDate >= '2024-09-25'));
		    쿼리문 참고
		    */
		 
		 
		
		return "redirect:/reserve/reserveEnd?reserveNum="+reserveNum;
	}
	
	@Override
	public String reserveEnd(HttpServletRequest request,Model model) {
		
		String reserveNum  = request.getParameter("reserveNum");
		
	    ReserveDto rdto = mapper.getreserveEnd(reserveNum);
		
		model.addAttribute("rdto",rdto);
		
		 
		 return "/reserve/reserveEnd";
	}
	
	
	
}
