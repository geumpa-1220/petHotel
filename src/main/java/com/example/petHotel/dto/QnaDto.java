package com.example.petHotel.dto;

import java.sql.Timestamp;

public class QnaDto {
	private int id,userid;
	private String title,content,acontent;
	private Timestamp qtime,atime;

	
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
	public String getAcontent() {
		return acontent;
	}
	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}
	public Timestamp getQtime() {
		return qtime;
	}
	public void setQtime(Timestamp qtime) {
		this.qtime = qtime;
	}
	public Timestamp getAtime() {
		return atime;
	}
	public void setAtime(Timestamp atime) {
		this.atime = atime;
	}
		
}
