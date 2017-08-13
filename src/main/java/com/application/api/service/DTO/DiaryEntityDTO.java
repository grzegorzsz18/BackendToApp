package com.application.api.service.DTO;

import java.util.Date;

public class DiaryEntityDTO {
	
	private int id;
	String title;
	String authorId;
	Date date;
	String text;
	

	public DiaryEntityDTO(String title, String authorId, Date date, String text) {
		this.title = title;
		this.authorId = authorId;
		this.date = date;
		this.text = text;
	}


	public DiaryEntityDTO() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthorId() {
		return authorId;
	}


	public void setAuthorId(String author) {
		this.authorId = author;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}
	
	
	
}
