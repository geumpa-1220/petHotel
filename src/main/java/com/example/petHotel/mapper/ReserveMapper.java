package com.example.petHotel.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.petHotel.dto.ReserveDto;
import com.example.petHotel.dto.RoomDto;


@Mapper
public interface ReserveMapper {

	
	public ArrayList<RoomDto> getRoom();
	public RoomDto reserveContent(String roomid);
	
	public void reserveOk(ReserveDto reDto);
	
	public ReserveDto getreserveEnd(String reserveNum);
}
