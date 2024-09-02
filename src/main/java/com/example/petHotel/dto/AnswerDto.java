package com.example.petHotel.dto;

import java.sql.Timestamp;

public class AnswerDto {
	private int id,qid;
	private String content;
	private Timestamp atime;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getAtime() {
		return atime;
	}
	public void setAtime(Timestamp atime) {
		this.atime = atime;
	}
	
	

}
