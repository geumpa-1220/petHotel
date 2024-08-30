package com.example.petHotel.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data

public class QuestionDto {
	private int id,userid;
	private String title,content;
	private Timestamp qtime;

}
