package com.example.petHotel.dto;

import java.sql.Timestamp;

import lombok.Data;



public class QuestionDto {
	private int id,userid;
	private String username,title,content;
	private Timestamp qtime;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getQtime() {
		return qtime;
	}
	public void setQtime(Timestamp qtime) {
		this.qtime = qtime;
	}
	

}
